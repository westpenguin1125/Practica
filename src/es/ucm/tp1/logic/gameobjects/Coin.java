package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends GameObject{
	
	final public static String COIN_INFO = "[Coin] gives 1 coin to the player";
	
	private static int numCoins = 0;

	public static void reset() {
		numCoins = 0;	
	}
	
	public static int getNumCoins() {
		return numCoins;
	}
	
	private boolean alive;
	
	final private String COIN_SYMBOL = "¢";
	
	public Coin( Game game, int x, int y) {
		super(game, x, y);
		symbol = COIN_SYMBOL;
		alive = true;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.increaseCoins();
		alive = false;
		return false;
	}
	
	@Override
	public boolean isAlive(){
		return alive;
	}
	
	@Override
	public void onEnter() {
		numCoins++;
	}
	
	@Override
	public void onDelete() {
		numCoins--;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public void update() {
	}
}
