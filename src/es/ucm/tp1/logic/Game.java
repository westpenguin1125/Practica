package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;//TODO -> maybe?
//TODO ASK import de GameObject en Game, si no no se puede pasar como parametro al metodo tryToAddObject
//Obstacle y Coin son temporales
import es.ucm.tp1.logic.gameobjects.*;


public class Game {
	
	private final String GOAL_SYMBOL = "¦";
	private GameObjectContainer objectList;
	//TODO Borrar
	private CoinList coinList;
	private ObstacleList obstacleList;
	
	private long seed;
	private Level level;
	
	private Player player;
	
	private Random random;
	
	private boolean testingFlag;
	private int numCycles;
	
	private long startTime;
	private long elapsedTime;
	
	public Game(long seed, Level level) {
		objectList = new GameObjectContainer();
		coinList = new CoinList(level.getRoadLength());
		obstacleList = new ObstacleList(level.getRoadLength());
  
		this.seed = seed;
		this.level = level;
		
		player = new Player(this, 0, level.getRoadWidth() / 2 );
		
		random = new Random(seed);
		
		testingFlag = level == Level.TEST;
		numCycles = 0;
	}
	
	private double getRandomNumber() {
		return random.nextDouble();
	}
	
	private int getRandomLane() {
		return (int) (getRandomNumber() * getRoadWidth());
	}
	
	//TODO yatusabes
//	public void tryToAddObject(GameObject obj, int x, int y) {
//		
//	}
	
	private void tryToAddCoin(Coin c, double freq) {
		
		if(getRandomNumber() < freq && gameObjectIn(c.getX(), c.getY()) != null)
			coinList.addCoin(c);
	}
	
	private void tryToAddObstacle(Obstacle o, double freq) {
		
		if(getRandomNumber() < freq && gameObjectIn(o.getX(), o.getY()) != null)
			obstacleList.addObstacle(o);
	}
	
	private void tryToFillObjectLists() {
		
		for(int i = getVisibility() / 2; i < getRoadLength(); i++) {
			tryToAddObstacle(new Obstacle(this, i, getRandomLane()), level.getObstacleFrequency());
			tryToAddCoin(new Coin(this, i, getRandomLane()), level.getCoinFrequency());
		}
	}
	
	public void initialize() {
		random.setSeed(seed);
		player.initialize(0, level.getRoadWidth() / 2);
		
		tryToFillObjectLists();
		numCycles = 0;
		
		elapsedTime = 0;
	}
	
	public void update() {
		player.update();
		numCycles++;
	}
	
	public void removeDeadObjects() {
		coinList.removeDeadCoins();
	}
	
	public void toggleTest() {
		testingFlag = true;
	}
	
	public boolean checkEnd() {
		return !playerIsAlive() || win();
	}
	
	public Coin coinIn(int x, int y) {
		return coinList.coinIn(x, y);
	}
	
	public Obstacle obstacleIn(int x, int y) {
		return obstacleList.obstacleIn(x, y);
	}
	
	public GameObject gameObjectIn(int x, int y) {
		return objectList.gameObjectIn(x, y);
	}
	
	public long getElapsedTime() {
		return elapsedTime;
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
	
	public int getRemainingDistance() {
		return getRoadLength() - player.getX();
	}
	public int getPlayerCoins() {
		return player.getNumCoins();
	}
	
	public Object getNumObstacles() {
		return Obstacle.getNumObstacles();
	}
	
	public Object getNumCoins() {
		return Coin.getNumCoins();
	}
	public boolean playerIsAlive() {
		return player.isAlive();
	}
	
	public boolean win() {
		return player.getX() > getRoadLength();
	}
	
	public String positionToString(int x, int y) {
		x +=  player.getX();
		
		String symbolToPrint;
		Coin c = coinList.coinIn(x, y);
		Obstacle o = obstacleList.obstacleIn(x, y);
		
		if (player.isInPosition(x, y)) 
			symbolToPrint = player.toString();
		else if(c != null)
			symbolToPrint = c.toString();
		else if(o != null)
			symbolToPrint = o.toString();
		else if (getRoadLength() == x) 
			symbolToPrint = GOAL_SYMBOL;
		else
			symbolToPrint = "";
		
		return symbolToPrint;
	}
}
