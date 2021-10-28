package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;

public abstract class GameObject implements Collider {

	protected Game game;

	protected int x, y;

	protected String symbol;
	protected String objectInfo;
	//TODO ASK activated es el boolean que usaremos para isAlive()?
	protected boolean activated;

	protected GameObject() {
		
	}
	
	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
		activated = true;
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();
	
	protected void deactivate() {
		activated = false;
	}

	protected String getSymbol() {
		return symbol;
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
	
	public boolean isDeactivated() {
		return !activated;
	}

	public boolean isAlive() {
		return true;
	}
	
	public String getObjectInfo() {
		return objectInfo;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}

		return "";
	}
	
	// TODO add your code

}
