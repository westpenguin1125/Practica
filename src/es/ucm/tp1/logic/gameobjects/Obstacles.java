package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public abstract class Obstacles extends GameObject {
	
	private static final String[] SYMBOLS_BY_RESISTANCE = { "░", "▒", "█" };
	
	private static int numObstacles = 0;

	protected int numLifes;

	public static int getNumObstacles() {
		return numObstacles;
	}

	public static void reset() {
		numObstacles = 0;
	}
	
	public Obstacles(Game game, int x, int y) {
		super(game, x, y);
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
	public boolean isAlive() {
		return numLifes > 0;
	}

	@Override
	public void onDelete() {
		numObstacles--;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public void update() {
	}

	@Override
	protected String getSymbol() {
		return SYMBOLS_BY_RESISTANCE[numLifes - 1];
	}
	
	@Override
	public boolean receiveShoot() {
		numLifes--;
		return true;
	}
	
	@Override
	public boolean receiveThunder() {
		numLifes = 0;
		return true;
	}
}