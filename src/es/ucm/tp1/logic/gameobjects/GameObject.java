package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.exceptions.InvalidPositionException;

public abstract class GameObject implements Collider {

	protected Game game;

	protected int x, y;
	
	protected String symbol;
	protected String objectInfo;
	
	public GameObject(Game game, int x, int y){
		this.x = x;
		this.y = y;
		this.game = game;
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();
	
	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public abstract boolean isAlive();

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
	
	@Override
	public boolean doCollision() {
		return false;
	}
	
	@Override
	public boolean receiveWave(){
		x += 1;
		return true;
	}
	
	@Override 
	public boolean receiveExplosion() {
		return receiveShoot();
	}
	
	@Override
	public boolean receiveThunder() {
		return false;
	}
}