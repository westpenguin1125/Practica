package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;

public abstract class GameObject implements Collider {

	protected int x, y;

	protected Game game;

	protected String symbol;
	protected String objectInfo;
	protected boolean activated;

	protected GameObject() {
		
	}
	
	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
		activated = true;
	}

	protected String getSymbol() {
		return symbol;
	}
	
	protected void deactivate() {
		activated = false;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}

		return "";
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
		return true;
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();
	
	public String getObjectInfo() {
		return objectInfo;
	}


	// TODO add your code

}
