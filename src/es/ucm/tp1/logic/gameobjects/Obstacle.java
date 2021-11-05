package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Obstacle extends GameObject{

	
	private static int numObstacles = 0;

	public static void reset() {
		numObstacles = 0;
	}
	
	public static int getNumObstacles() {
		return numObstacles;
	}	
	
	final private String OBSTACLE_SYMBOL = "░";
	final public static String OBSTACLE_INFO = "[Obstacle] hits car";
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		symbol = OBSTACLE_SYMBOL;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.decreaseLife();
		return false;
	}
	
	@Override
	public void onEnter() {
		numObstacles++;
	}

	@Override
	public void onDelete() {
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public void update() {
	}
}
