package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public abstract class Obstacles extends GameObject {
	
	private static final String[] SYMBOLS_BY_RESISTANCE = { "░", "▒", "█" };
	
	private static int numObstacles = 0;

	protected int numLifes;

	public static void reset() {
		numObstacles = 0;
	}

	public static int getNumObstacles() {
		return numObstacles;
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
	public boolean receiveShoot() {
		numLifes--;
		return true;
	}
	
	@Override
	public boolean receiveExplosion() {
		numLifes = 0;
		return true;
	}
	
	@Override
	public boolean receiveThunder() {
		System.out.print(" -> " + getSymbol());
		numLifes = 0;
		return true;
	}

	@Override
	public void onEnter() {
		numObstacles++;
	}

	@Override
	public void onDelete() {
		numObstacles--;
	}
	
	@Override
	public boolean isAlive() {
		return numLifes > 0;
	}

	@Override
	protected String getSymbol() {
		return SYMBOLS_BY_RESISTANCE[numLifes - 1];
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public void update() {
	}
}