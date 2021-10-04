package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.control.Commands;

public class Game {
	
	private CoinList coinList;
	private ObstacleList obstacleList;
	
	private long seed;
	private Level level;
	
	private Player player;
	
	private boolean testingFlag;
	private Random random;
	private int numCicles;

	public Game(long seed, Level level) {

		coinList = new CoinList(level.getRoadLength());
		obstacleList = new ObstacleList(level.getRoadLength());
		
		numCicles = 0;
		this.seed = seed;
		this.level = level;
		
		player = new Player(0, level.getRoadWidth() / 2, this);
		
		testingFlag = false;
		
		random = new Random(seed);
		
	}
	
	public boolean gameObjIsIn(Position pos) {
		return (coinList.someIn(pos) || obstacleList.someIn(pos));
	}
	
	private double getRandomNumber() {
		return random.nextDouble();
	}
	
	private int getRandomLane() {
		return (int) (getRandomNumber() * getRoadWidth());
	}
	
	public int getNumCicles() {
		return numCicles;
	}
	
	private void tryToAddCoin(Coin c, double freq) {
		
		if(getRandomNumber() < freq)
			coinList.tryToAdd(c);
	}
	
	private void tryToAddObstacle(Obstacle o, double freq) {
		
		if(getRandomNumber() < freq)
			obstacleList.tryToAdd(o);
	}
	
	private void tryToFillObjectLists() {
		double rand;
		
		for(int i = getVisibility() / 2; i < getRoadLength(); i++) {
			tryToAddObstacle(new Obstacle(i, getRandomLane(), this), level.getObstacleFrequency());
			tryToAddCoin(new Coin(i, getRandomLane(), this), level.getCoinFrequency());
		}
	}
	
	public void initialize() {
		player.initialize(0, level.getRoadWidth() / 2);
		random.setSeed(seed);
		numCicles = 0;
		
		tryToFillObjectLists();
	}
	
	public void update(Commands comando) {
		numCicles++;
		
		switch (comando) {
		//Preguntar codigo repetido?
		case UP:
			player.moveUp();
			player.moveForward();
			break;
		case DOWN:
			player.moveDown();
			player.moveForward();
			break;
		case FORWARD:
			player.moveForward();
			break;
		case RESET:
			initialize();
			break;

			//TODO increase coins
			
		default:
			break;
		}
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
		String s;
		Position pos = new Position(x, y);
		
		if (player.isIn(x, y)) 
			s = player.toString();
		else if(coinList.someIn(pos))
			s = coinList.toString();
		else if(obstacleList.someIn(pos))
			s = obstacleList.toString();
		else
			s = "";
		
		return s;
	}
}
