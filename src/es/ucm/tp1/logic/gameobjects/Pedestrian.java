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
		movingUp = true;
	}
	
	@Override
	public boolean receiveShoot() {
		game.punishPlayer();
		return super.receiveShoot();
	}

	@Override
	public void update() {
		if(y == 0)
			movingUp = false;
		else if(y == game.getRoadWidth() - 1)
			movingUp = true;
		
		if(movingUp)
			y--;
		else
			y++;
	}
	
	@Override
	public String getSymbol() {
		return symbol;
	}
}