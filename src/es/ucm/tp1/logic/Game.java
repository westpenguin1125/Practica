package es.ucm.tp1.logic;

import java.util.Random;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.instantactions.InstantAction;
import es.ucm.tp1.control.exceptions.IORecordException;

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

	private Record record;

	public Game(long seed, Level level) {

		player = new Player(this, 0, level.getRoadWidth() / 2);
		initialize(seed, level);
	}

	public double getRandomNumber() {
		return random.nextDouble();
	}

	public void initialize(Long seed, Level level) {
		this.seed = seed;
		this.level = level;

		try {
			record = new Record(level);

			exit = false;
		}
		catch (IORecordException e) {
			System.out.println(e.getMessage());
			exit = true;
		}
		finally {
			random = new Random(seed);

			objectList = new GameObjectContainer();
			GameObjectGenerator.reset();

			GameObjectGenerator.generateGameObjects(this, level);

			player.initialize(0, level.getRoadWidth() / 2);

			numCycles = 0;

			elapsedTime = 0;
		}
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

	public void addObject(GameObject obj) {
		objectList.addObject(obj);
	}

	public boolean isValidEmptyPosition(int x, int y) {
		return inVisibility(x, y) && isEmpty(x, y);
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

		removeDeadObjects();
	}
	
	public void removeDeadObjects() {
		objectList.removeDeadObjects();
	}

	public String serializeGameObjectsIn(int x, int y) {
		String serialized = new String();
		if (player.isInPosition(x, y))
			serialized = player.serialize() + "\n";

		return serialized + objectList.serializeGameObjectsIn(x, y);
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

	public void setNewRecord(double newTime) throws IORecordException {
		record.setNewRecord(newTime);
	}

	public void showRecord() {
		record.showRecord();
	}

	public double getRecord() {
		return record.getRecord();
	}

	public boolean isNewRecord(double time) {
		return getRecord() > time;
	}

	public boolean inVisibility(int x, int y) {
		return getPlayerX() <= x && x < getVisibility() + getPlayerX() && 0 <= y && y < getRoadWidth();
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

	public GameObject algo(int x, int y) {
		if (player.isInPosition(x, y))
			return player;
		else
			return gameObjectIn(x, y);
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

	public boolean inValidPosition(int x, int y) {
		return (0 <= x && (0 <= y && y < getRoadWidth()));
	}

	public String positionToString(int x, int y) {
		x += player.getX();

		String symbolToPrint = "";

		if (player.isInPosition(x, y))
			symbolToPrint = player.toString() + " ";

		symbolToPrint += objectList.positionToString(x, y);

		if (getRoadLength() == x)
			symbolToPrint += GOAL_SYMBOL;

		return symbolToPrint.trim();
	}
}