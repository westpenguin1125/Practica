package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends GameObject{
	
	final private String COIN_SYMBOL = "¢";
	final public static String COIN_INFO = "[Coin] gives one coin to the player";
	private static int numCoins;
	
	
	public Coin( Game game, int x, int y) {
		super(game, x, y);
		symbol = COIN_SYMBOL;
	}
	
	public static int getNumCoins() {
		return numCoins;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.increaseCoins();
		kill();
		
		return false;
	}

	@Override
	public void update() {
	}
	
	@Override
	public void onEnter() {
		numCoins++;
	}
	
	@Override
	public void onDelete() {
		numCoins--;
	}

	public static void reset() {
	numCoins = 0;
		
	}
	
	
}
