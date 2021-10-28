package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends GameObject{
	
	final private String COIN_SYMBOL = "¢";
	final private String COIN_INFO = "[Coin] gives one coin to the player";
	private static int numCoins;
	

	

	
	public Coin() {
		objectInfo = COIN_INFO;
	}
	
	public Coin( Game game, int x, int y) {
		
		super(game, x, y);
	}
	
	public void onEnter() {
		numCoins++;
	}
	
	public void onDelete() {
		numCoins--;
	}
	
	public static int getNumCoins() {
		return numCoins;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isDeactivated() {
		return !activated;
	}
	
	@Override
	public String toString() {
		return COIN_SYMBOL;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			return (x == ((Coin) obj).getX() &&
					y == ((Coin) obj).getY());
		}
	}
	

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.increaseCoins();
		deactivate();
		
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	
}
