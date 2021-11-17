package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends Coins{
	public Coin(Game game, int x, int y) {
		super(game, x, y);
		symbol = COIN_SYMBOL;
		coinsGiven = COINS_GIVEN;
	}

	final public static String COIN_INFO = "[Coin] gives 1 coin to the player";
	final private String COIN_SYMBOL = "¢";
	
	final private static int COINS_GIVEN = 1;

	private static int numCoins = 0;

	public static void reset() {
		numCoins = 0;	
	}
	
	public static int getNumCoins() {
		return numCoins;
	}
	
	@Override
	public void onEnter() {
		numCoins++;
	}
	
	@Override
	public void onDelete() {
		numCoins--;
	}
	
}
