package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;//TODO -> maybe?
//TODO ASK import de GameObject en Game, si no no se puede pasar como parametro al metodo tryToAddObject
//Obstacle y Coin son temporales
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.GameObjectGenerator;


public class Game {
	
	private final String GOAL_SYMBOL = "¦";
	private GameObjectContainer objectList;
	
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
	
	public int getRandomLane() {
		return (int) (getRandomNumber() * getRoadWidth());
	}
	

	public void tryToAddObject(GameObject obj, double frequency) {
		if (getRandomNumber() < frequency && gameObjectIn(obj.getX(), obj.getY()) == null) {
			objectList.addObject(obj);
		}
	}
	
	public void initialize() {
		random.setSeed(seed);
		player.initialize(0, level.getRoadWidth() / 2);
		GameObjectGenerator.generateGameObjects(this, level);
		
		numCycles = 0;
		
		elapsedTime = 0;
	}
	
	public void update() {
		player.update();
		numCycles++;
		
		if(numCycles == 1) 
			startTime = System.currentTimeMillis();
		
		elapsedTime = System.currentTimeMillis() - startTime;
	}
	
	public void PlayerMoveUP() {
		player.moveUp();
	}
	
	public void PlayerMoveDown() {
		player.moveDown();
	}

	public void removeDeadObjects() {
		objectList.removeDeadObjects();
	}
	
	public void toggleTest() {
		testingFlag = true;
	}
	
	public boolean checkEnd() {
		return !playerIsAlive() || win();
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
	
	public boolean playerIsAlive() {
		return player.isAlive();
	}
	
	public boolean win() {
		return player.getX() > getRoadLength();
	}
	
	public String positionToString(int x, int y) {
		x +=  player.getX();
		
		String symbolToPrint;
		GameObject obj = objectList.gameObjectIn(x, y);
		
		if(player.isInPosition(x, y))
			symbolToPrint = player.toString();
		else if(obj != null)
			symbolToPrint = obj.toString();
		else
			symbolToPrint = "";
		
		return symbolToPrint;
	}

}
