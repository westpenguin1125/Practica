package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.*;


public class GameObjectGenerator {

//	public static void generateGameObjects(Game game, Level level) {
//
//		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
//			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.obstacleFrequency());
//			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.coinFrequency());
//		}
//	}

	private static final GameObject[] gameObjects = {
			new Player(),
			new Coin(),
			new Obstacle(),
		};
	
	public static String getObjectInfo() {
		StringBuilder buffer = new StringBuilder();
		//TODO puede dar error en el futuro
		for (GameObject gameObject : gameObjects) {
			buffer.append(gameObject.getObjectInfo());
			buffer.append(System.lineSeparator());
		}
		
		return buffer.toString();
	}
	
	public static void reset(Level level) {
		// TODO add your code
	}

	public static void generateRuntimeObjects(Game game) {
		// TODO add your code
	}
}
