package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Obstacle extends Obstacles {

	final public static String OBSTACLE_INFO = "[Obstacle] hits car";

	final private static int OBSTACLE_RESISTANCE = 1;

	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		numLifes = OBSTACLE_RESISTANCE;
	}
}