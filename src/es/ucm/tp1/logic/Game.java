package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Direction;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Player;

public class Game {

	private final String GOAL_SYMBOL = "¦";

	private GameObjectContainer objectList;

	private long seed;
	private Level level;

	private Player player;

	private int numCycles;

	private long startTime;
	private long elapsedTime;

	private boolean testingFlag;
	private boolean exit;

	private Random random;

	public Game(long seed, Level level) {

		player = new Player(this, 0, level.getRoadWidth() / 2);
		initialize(seed, level);
	}

	public void initialize(Long seed, Level level) {
		this.seed = seed;
		this.level = level;

		random = new Random(seed);

		emptyObjectList();

		GameObjectGenerator.reset();
		GameObjectGenerator.generateGameObjects(this);

		player.initialize(0, level.getRoadWidth() / 2);

		numCycles = 0;

		elapsedTime = 0;

		testingFlag = level == Level.TEST;
		exit = false;
	}

	public void initialize() {
		initialize(seed, level);
	}
	
	public void emptyObjectList() {
		objectList = new GameObjectContainer();
	}

	private double getRandomNumber() {
		return random.nextDouble();
	}

	public int getRandomLane() {
		return (int) (getRandomNumber() * getRoadWidth());
	}

	public void tryToAddObject(GameObject obj, double frequency) {
		if (getRandomNumber() < frequency && isEmpty(obj.getX(), obj.getY()))
			objectList.addObject(obj);
	}
	
	public void forceAddObject(GameObject obj) {
		objectList.forceAddObject(obj);
	}

	public void update() {
		numCycles++;

		if (numCycles == 1)
			startTime = System.currentTimeMillis();

		elapsedTime = System.currentTimeMillis() - startTime;
	}

	public void removeDeadObjects() {
		objectList.removeDeadObjects();
	}
	
	public void movePlayer(Direction dir) {
		player.move(dir);
		update();
	}
	
	public void rewardPlayer(int reward) {
		player.increaseCoins(reward);
	}

	public void toggleTest() {
		testingFlag = true;
	}

	public void exitGame() {
		exit = true;
	}
	
	public void execute(InstantAction action) {
		action.execute(this);
	}

	public boolean isFinished() {
		return !playerIsAlive() || win() || exit;
	}

	public boolean isEmpty(int x, int y) {
		return gameObjectIn(x, y) == null;
	}
	
	public GameObject gameObjectIn(int x, int y) {
		return objectList.gameObjectIn(x, y);
	}

	public int getRemainingDistance() {
		return getRoadLength() - player.getX();
	}
	
	public int lastColumnVisible() {
		return getPlayerX() + getVisibility() - 1;
	}

	public boolean win() {
		return player.getX() > getRoadLength();
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

	public double coinFrequency() {
		return level.coinFrequency();
	}

	public double obstacleFrequency() {
		return level.obstacleFrequency();
	}

	public int getPlayerX() {
		return player.getX();
	}
	
	public int getPlayerY() {
		return player.getY();
	}
	
	public int getPlayerCoins() {
		return player.getNumCoins();
	}

	public boolean playerIsAlive() {
		return player.isAlive();
	}

	public int getNumCycles() {
		return numCycles;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public boolean getTestingFlag() {
		return testingFlag;
	}

	public String positionToString(int x, int y) {
		x += player.getX();

		String symbolToPrint = "";

		if (player.isInPosition(x, y))
			symbolToPrint = player.toString() + " ";
		
		symbolToPrint += objectList.positionToString(x, y);
		
		if(getRoadLength() == x)
			symbolToPrint += GOAL_SYMBOL;

		return symbolToPrint;
	}
}