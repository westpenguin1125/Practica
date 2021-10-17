package es.ucm.tp1.logic;

public class Coin {
	
	final private String COIN_SYMBOL = "¢";

	private static int numCoins;
	
	private Game game;
	
	private int x;
	private int y;
	
	private boolean activated;
	
	public Coin(int x, int y, Game game) {

		this.game = game;
    
		this.x = x;
		this.y = y;
		
		activated = true;
	}
	
	public void onEnter() {
		numCoins++;
	}
	
	public void onDelete() {
		numCoins--;
	}
	
	public void deactivate() {
		activated = false;
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
	
	public boolean isIn(int x, int y) {
		return (this.x == x && this.y == y);
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
}
