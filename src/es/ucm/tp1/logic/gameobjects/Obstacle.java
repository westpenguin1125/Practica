package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Obstacle extends Obstacles{

	private final int RESISTENCIA = 1;
	

	
	final public static String OBSTACLE_INFO = "[Obstacle] hits car";
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		
		numLifes = RESISTENCIA;
	}
}
