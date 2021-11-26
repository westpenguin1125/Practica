package es.ucm.tp1.logic;

import java.util.Random;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.instantactions.InstantAction;

public class Game {

	private final String GOAL_SYMBOL = "¦";
	
	//TODO ASK if okay porque lo hemos cambiado de SuperCars a Game


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

	private double getRandomNumber() {
		return random.nextDouble();
	}

	public void initialize(Long seed, Level level) {
		this.seed = seed;
		this.level = level;

		random = new Random(seed);
		
		
		objectList = new GameObjectContainer();
		GameObjectGenerator.reset();

		GameObjectGenerator.generateGameObjects(this, level);

		player.initialize(0, level.getRoadWidth() / 2);

		numCycles = 0;

		elapsedTime = 0;
		
		exit = false;
	}

	public void initialize() {
		initialize(seed, level);
	}
	
	public void emptyObjectList() {
		//GameObjectGenerator.reset();
		objectList.empty();
	}

	public int getRandomLane() {
		return (int) (getRandomNumber() * getRoadWidth());
	}

	public int getRandomVisibility() {
		return (int) (getRandomNumber() * getVisibility());
	}
	
	public void tryToAddObject(GameObject obj, double frequency) {
		if (getRandomNumber() < frequency && isEmpty(obj.getX(), obj.getY()))
			objectList.addObject(obj);
	}
	public void tryToAddObject(GameObject obj) {
		if (isEmpty(obj.getX(), obj.getY()))
			objectList.addObject(obj);
	}
	
	public void forceAddObject(GameObject obj) {
		objectList.forceAddObject(obj);
	}

	public void update() {
		
		//TODO ASK Qué debería pasar cuando está el player frente al truck, de eso depende el orden de estas instrucciones
		objectList.updateList();
		GameObjectGenerator.generateRuntimeObjects(this, level);
		numCycles++;		
		
		if (numCycles == 1)
			startTime = System.currentTimeMillis();

		elapsedTime = System.currentTimeMillis() - startTime;
		
		objectList.removeDeadObjects();
	}
	
	public boolean buy(int cost) {
		return player.buy(cost);
	}
	
	public void movePlayerUp() {
		player.moveUp();
	}
	
	public void movePlayerDown() {
		player.moveDown();
	}
	
	public void movePlayerForward() {
		player.moveForward();
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

	public void punishPlayer() {
		player.punish();
	}
	
	public boolean inVisibility(int x, int y) {
		return 0 <= x && x < getVisibility() &&
				0 <= y && y < getRoadWidth();
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