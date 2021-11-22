package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Pedestrian extends Obstacles{

	final public static String TRUCK_INFO = "[PEDESTRIAN] person crossing the road up and down";
	final private String PEDESTRIAN_SYMBOL = "☺";
	final private int PEDESTRIAN_RESISTANCE = 1;
	
	private boolean movingUp;
	
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
		symbol = PEDESTRIAN_SYMBOL;
		numLifes = PEDESTRIAN_RESISTANCE;
		//TODO COMO se empieza moviendo el pedestrian movingUp = true;
	}

	@Override
	public void update() {
		
	}
	
	@Override
	public String getSymbol() {
		return symbol;
	}
}