package es.ucm.tp1.logic;

import es.ucm.tp1.logic.gameobjects.*;


public class GameObjectGenerator {

	public static final int MAX_ID = 5;
	public static final int MIN_ID = 1;
	

	public static void forceAdvanceObject(Game game, int id, int x) {
		GameObject o = null;
		switch (id) {
		case 1:
		o = new Wall(game, x, game.getRandomLane());
		break;
		case 2:
		o = new Turbo(game, x, game.getRandomLane());
		break;
		case 3:
		o = new SuperCoin(game, x, game.getRandomLane());
		break;
		case 4:
		o = new Truck(game, x, game.getRandomLane());
		break;
		case 5:
		o = new Pedestrian(game, x, 0);
		break;
		}
		game.forceAddObject(o);
	}

	
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
		
	}
}
