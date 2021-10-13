package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.control.Command;


public class Game {
	
	private CoinList coinList;
	private ObstacleList obstacleList;
	
	private long seed;
	private Level level;
	
	private Player player;
	
	private Random random;
	private boolean testingFlag;
	//TOASK Este atributo es de Game?
	private int numCycles;
	private long startTime;
	private long elapsedTime;
	
	public Game(long seed, Level level) {

		coinList = new CoinList(level.getRoadLength());
		obstacleList = new ObstacleList(level.getRoadLength());

		this.seed = seed;
		this.level = level;
		
		player = new Player(0, level.getRoadWidth() / 2, this);
		
		random = new Random(seed);
		testingFlag = false;
		numCycles = 0;
		
	}
	
	private double getRandomNumber() {
		return random.nextDouble();
	}
	
	private int getRandomLane() {
		return (int) (getRandomNumber() * getRoadWidth());
	}
	
	private void tryToAddCoin(Coin c, double freq) {
		
		if(getRandomNumber() < freq && !gameObjIsIn(c.getX(), c.getY()))
			coinList.addCoin(c);
	}
	
	private void tryToAddObstacle(Obstacle o, double freq) {
		
		if(getRandomNumber() < freq && !gameObjIsIn(o.getX(), o.getY()))
			obstacleList.addObstacle(o);
	}
	
	private void tryToFillObjectLists() {
		
		for(int i = getVisibility() / 2; i < getRoadLength(); i++) {
			tryToAddObstacle(new Obstacle(i, getRandomLane(), this), level.getObstacleFrequency());
			tryToAddCoin(new Coin(i, getRandomLane(), this), level.getCoinFrequency());
		}
	}
	
	public void initialize() {
		player.initialize(0, level.getRoadWidth() / 2);
		random.setSeed(seed);
		elapsedTime = 0;
		
		tryToFillObjectLists();
		numCycles = 0;
	}
	
	public void update(Command command) {
		
		if(command == Command.RESET)
			initialize();
		else {
			if(command == Command.UP && player.getY() > 0)
				player.moveUp();
			else if(command == Command.DOWN && player.getY() < level.getRoadWidth() - 1)
				player.moveDown();
			
			player.moveForward();	
		}
		
		player.doCollitions();
		numCycles++;
		if (numCycles == 1) {
			startTime = System.currentTimeMillis();
		}
		else {
			elapsedTime = System.currentTimeMillis() - startTime;
		}
	}
	
	public long getElapsedTime() {
		return elapsedTime;
	}
	
	//TODO
	public void removeDeadObjects() {
		coinList.removeDeadObjects();
	}
	
	//TODO
	public boolean checkEnd() {
		return !player.isAlive() || player.getX() > level.getRoadLength();
	}
	
	public void toggleTest() {
		//TOASK Esto es todo?
		testingFlag = true;
	}
	
	public Coin coinIn(int x, int y) {
		return coinList.coinIn(x, y);
	}
	
	public Obstacle obstacleIn(int x, int y) {
		return obstacleList.obstacleIn(x, y);
	}
	
	public boolean gameObjIsIn(int x, int y) {
		return (coinIn(x, y) != null || obstacleIn(x, y) != null);
	}
	
	public boolean getTestingFlag() {
		return testingFlag;
	}
	
	public int getNumCycles() {
		return numCycles;
	}
	
	public int getVisibility() {
		return level.getVisibility();
	}
	
	public int getRoadLength() {
		return level.getRoadLength();
	}
	
	public int getRoadWidth() {
		return level.getRoadWidth();
	}
	
	
	public int getPlayerXPosition() {
		return player.getX();
	}
	public int getPlayerCoins() {
		return player.getNumCoins();
	}
	
	public Object getNumObstacles() {
		return obstacleList.getNumObstacles();
	}
	
	public Object getNumCoins() {
		return coinList.getNumCoins();
	}
	
	//Se debería sumar aqui esto? no Pertenece a Game creo yo
	public String positionToString(int x, int y) {
		String symbolToPrint;
		Coin c = coinList.coinIn(x + player.getX(), y);
		Obstacle o = obstacleList.obstacleIn(x + player.getX(), y);
		
		if (player.isIn(x + player.getX(), y)) 
			symbolToPrint = player.toString();
		else if(c != null)
			symbolToPrint = c.toString();
		else if(o != null)
			symbolToPrint = o.toString();
		else
			symbolToPrint = "";
		
		return symbolToPrint;
	}



}
