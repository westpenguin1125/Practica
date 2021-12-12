package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Turbo extends GameObject {

	final public static String TURBO_INFO = "[TURBO] pushes the car: 3 columns";
	final private String TURBO_SYMBOL = ">>>";

	protected boolean alive;

	public Turbo(Game game, int x, int y) {
		super(game, x, y);
		symbol = TURBO_SYMBOL;
		alive = true;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.jump();
		alive = false;
		return true;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	public boolean receiveShoot() {
		return false;
	}
}