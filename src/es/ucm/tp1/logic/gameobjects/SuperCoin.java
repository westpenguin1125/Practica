package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class SuperCoin extends Coins {

	final public static String SUPERCOIN_INFO = "[SUPERCOIN] gives 1000 coins";
	final private String SUPERCOIN_SYMBOL = "$";

	final static int COINS_GIVEN = 1000;

	private static boolean isPresent = false;

	public static void reset() {
		isPresent = false;
	}

	public static boolean isPresent() {
		return isPresent;
	}

	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
		symbol = SUPERCOIN_SYMBOL;
		coinsGiven = COINS_GIVEN;
	}

	@Override
	public void onEnter() {
		isPresent = true;
	}

	@Override
	public void onDelete() {
		isPresent = false;
	}
}