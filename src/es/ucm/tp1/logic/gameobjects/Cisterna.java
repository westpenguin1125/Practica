package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.instantactions.ExplodeAction;

//Si recibe explosión también explota
//Si recibe disparo se le pinchan las ruedas
//Si recoge moneda aumenta en uno su rango de explosión
public class Cisterna extends Truck{
	
	final private String CISTERNA_SYMBOL = "←:";
	
	private boolean ruedasPinchadas = false;
	private int range = 1;

	public Cisterna(Game game, int x, int y) {
		super(game, x, y);
		symbol = CISTERNA_SYMBOL;
	}
	
	public void increaseRange() {
		range *= 2;
	}
	
	@Override
	public boolean receiveShoot(){
		ruedasPinchadas = true;
		return true;
	}
	
	@Override
	public void update() {
		if(!ruedasPinchadas) {
			super.update();
			doCollision();
		}
	}
	
	@Override
	public boolean receiveExplosion(){
		super.receiveExplosion();
		game.execute(new ExplodeAction(getX(), getY(), range));
		return true;
	}
	
	@Override
	protected String getSymbol() {
		return super.getSymbol() + "[" + range + "]";
	}
	
	@Override
	public boolean doCollision(){
		GameObject obj = game.gameObjectIn(getX(), getY());
		if(obj != null)
			obj.receiveCollision(this);
		
		return false;
	}
}
