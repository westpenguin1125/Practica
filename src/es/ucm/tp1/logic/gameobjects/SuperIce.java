package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class SuperIce extends Ice{
	
	final public static String SUPERICE_INFO = "[SuperICE] Makes the car to drift for 3 cycles";
	final private String SUPERICE_SYMBOL = "***";
	
	private static final int DRIFTING_CYCLES = 3;

	public SuperIce(Game game, int x, int y) {
		super(game, x, y);
		numCycles = DRIFTING_CYCLES;
		symbol = SUPERICE_SYMBOL;
	}

}
