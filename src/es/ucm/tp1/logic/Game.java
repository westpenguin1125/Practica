package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class Game {
	
	private CoinList coinList;
	private ObstacleList obstacleList;
	
	private long seed;
	private Level level;
	
	private Player player;
	
	private boolean testingFlag;
	private Random random;

	public Game(long seed, Level level) {

		coinList = new CoinList(level.getRoadLength());
		obstacleList = new ObstacleList(level.getRoadLength());
		
		this.seed = seed;
		this.level = level;
		
		player = new Player(0, level.getRoadWidth() / 2, this);
		
		testingFlag = false;
		
		random = new Random(seed);
		
	}
	
	public boolean gameObjIsIn(Position pos) {
		return (coinList.someIn(pos) || obstacleList.someIn(pos));
	}
	
	private int getRandomLane() {
		//TODO fixear Random
		return random.nextInt() % getRoadWidth();
	}
	
	private void tryToFillObjectLists() {
		double rand;
		
		for(int i = getVisibility() / 2; i < getRoadLength(); i++) {
			//TOCOMMENT he visto en los tests que puede haber mas de un obstaculo en una misma columna
			//TOASK consultar si primero se añaden coins y luego obstacles o al reves
			//TODO fixear Random
			
			rand = random.nextDouble();
			if(rand < level.getCoinFrequency())
				coinList.tryToAddIn(new Coin(new Position(i, getRandomLane()), this));
			
			rand = random.nextDouble();
			if(rand < level.getObstacleFrequency())
				obstacleList.tryToAddIn(new Obstacle(new Position(i, getRandomLane()), this));
		}
	}
	
	public void initialize() {
		//TODO comportamiento necesario para inicializar los atributos de game cuando se use el comando reset o se inicie un juego
		//Estos atributos toman en cuenta el level y la seed para tomar sus valores
		player.initialize(new Position(0, level.getRoadWidth() / 2));
		random.setSeed(seed);
		
		//TODO inicializacion del random
		tryToFillObjectLists();
	}
	
	public void toggleTest() {
		// TODO comportamiento necesario para actualizar el flag testingFlag cuando se indique por comando
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
	
	public void checkCollitions() {
		if (coinList.someIn(player.getPos())) {
			player.increaseCoins();
		}
		else if (obstacleList.someIn(player.getPos())) {
			player.decreaseLife();
		}
	}
	
	public String positionToString(int x, int y) {
		//TODO dibuja el objeto que está en la posición
		
		if (player.isIn(x, y)) {
			return player.toString();
		}
		String s = coinList.positionToString(x, y);
		if(s != null)
			return s;
		
		return "";
	}
}
