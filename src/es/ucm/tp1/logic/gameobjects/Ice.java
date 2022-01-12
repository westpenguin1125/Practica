package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Ice extends Turbo{

	final public static String ICE_INFO = "[ICE] Makes the car to drift for 1 cycle";
	final private String ICE_SYMBOL = "*";
	
	private static final int DRIFTING_CYCLES = 1;
	
	protected int numCycles;
	
	public Ice(Game game, int x, int y) {
		super(game, x, y);
		symbol = ICE_SYMBOL;
		numCycles = DRIFTING_CYCLES;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.drift(numCycles);
		return true;
	}
}
