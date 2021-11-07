package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;

public abstract class GameObject implements Collider {

	protected Game game;

	protected int x, y;
	
	protected boolean alive;

	protected String symbol;
	protected String objectInfo;
	
	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
		alive = true;
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();
	
	protected void kill() {
		alive = false;
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isAlive() {
		return alive;
	}

	protected String getSymbol() {
		return symbol;
	}
	
	public String getObjectInfo() {
		return objectInfo;
	}

	@Override
	public String toString() {
		if (isAlive()) 
			return getSymbol();

		return "";
	}
}
