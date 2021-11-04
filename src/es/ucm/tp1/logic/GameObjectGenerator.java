package es.ucm.tp1.logic;

import es.ucm.tp1.logic.gameobjects.*;


public class GameObjectGenerator {

	public static void generateGameObjects(Game game) {

		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), game.obstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), game.coinFrequency());
		}
	}

	public static void reset() {
		Coin.reset();
		Obstacle.reset();
	}

	public static void generateRuntimeObjects(Game game) {
		//TODO Práctica 2
	}
}
