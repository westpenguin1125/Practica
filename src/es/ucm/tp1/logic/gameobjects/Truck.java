package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Truck extends Obstacles{

	final public static String TRUCK_INFO = "[TRUCK] moves towards the player";
	final private String TRUCK_SYMBOL = "←";
	final private int TRUCK_RESISTANCE = 1;
	

	
	public Truck(Game game, int x, int y) {
		super(game, x, y);
		symbol = TRUCK_SYMBOL;
		numLifes = TRUCK_RESISTANCE;
	}

	@Override
	protected String getSymbol() {
		return symbol; //TODO ASK if okay to do this override
	}
	
	@Override
	public void update() {
		x--;
	}
	
}
