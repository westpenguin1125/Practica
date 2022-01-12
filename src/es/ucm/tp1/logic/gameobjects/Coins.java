package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public abstract class Coins extends GameObject {

	private boolean alive;
	protected int coinsGiven;

	public Coins(Game game, int x, int y) {
		super(game, x, y);
		alive = true;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.increaseCoins(coinsGiven);
		alive = false;
		return false;
	}
	
	@Override
	public boolean receiveCollision(Cisterna cisterna) {
		cisterna.increaseRange();
		alive = false;
		return false;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public void update() {
	}
}