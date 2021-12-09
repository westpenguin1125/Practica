package es.ucm.tp1.logic;

import java.util.Random;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.control.exceptions.InvalidPositionException;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.instantactions.InstantAction;

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
	public void addObject(GameObject obj) throws InvalidPositionException {
		//TODO Asi esta bien esta excepcion?
		//Hay que lanzar la excepcion cuando la posicion proporcionada no está en la carretera o cuando no está en visibilidad
		if (!inVisibility(obj.getX(), obj.getY()) ||
				!isEmpty(obj.getX() , obj.getY())) {
			throw new InvalidPositionException("Invalid position."); 
		}
		objectList.addObject(obj);
	}
	
	public void delCol(int x) {
		objectList.delObjectsInCol(x);
	}
	
	public void forceAddObject(GameObject obj) {
		objectList.forceAddObject(obj);
	}

	public void update() {
		
		objectList.updateList();
		GameObjectGenerator.generateRuntimeObjects(this, level);
		numCycles++;		
		
		if (numCycles == 1)
			startTime = System.currentTimeMillis();

		elapsedTime = System.currentTimeMillis() - startTime;
		
		objectList.removeDeadObjects();
	}
	
	public String serialize() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append(player.serialize() + "\n");
		buffer.append(objectList.serialize(getRoadLength(), getRoadWidth()));
		
		return buffer.toString();
	}
	
	public String levelString() {
		return level.toString();
	}
	
	public void buy(int cost) {
		player.buy(cost);
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
		return getPlayerX() <= x && x < getVisibility() + getPlayerX() &&
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

		return symbolToPrint.trim();
	}
}