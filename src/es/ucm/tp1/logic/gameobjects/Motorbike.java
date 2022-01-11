package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.instantactions.AdviceDeadMotoAction;

public class Motorbike extends Truck{
	
	final private static int MAX_NUM_MOTOS = 2;
	private static int num_motos = 0;
	
	final public static String MOTORBIKE_INFO = "[MOTORBIKE] moves towards the player and if there is two motos and one gets killed, then the other is also killed";
	final private String MOTORBIKE_SYMBOL = "M";
	final private int MOTORBIKE_RESISTANCE = 1;

	public static boolean canPutMoreMotos() {
		return num_motos < MAX_NUM_MOTOS;
	}
	
	public static int getNumMotos() {
		return num_motos;
	}
	
	public Motorbike(Game game, int x, int y) {
		super(game, x, y);
		symbol = MOTORBIKE_SYMBOL;
		numLifes = MOTORBIKE_RESISTANCE;
	}

	@Override
	public void adviceDeadMoto() {
		numLifes = 0;
	}
	
	@Override
	public void update() {
		super.update();
		if(!isAlive())
			game.execute(new AdviceDeadMotoAction());
	}
	
	@Override
	public void onEnter() {
		super.onEnter();
		num_motos++;
	}

	@Override
	public void onDelete() {
		super.onDelete();
		num_motos--;
	}
}
