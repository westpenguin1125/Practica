package es.ucm.tp1.logic;

public class Coin {
	
	
	final private String COIN_SYMBOL = "¢";

	private static int numCoins;
	
	private int x;
	private int y;
	
	private Game game;
	
	
	public void onEnter() {
		numCoins++;
	}
	
	public void onDelete() {
		numCoins--;
	}
	
	public static int getNumCoins() {
		return numCoins;
	}
	
	private boolean activated;
	
	public Coin(int x, int y, Game game) {
		
		this.x = x;
		this.y = y;
		 
		this.game = game;
		
		activated = true;
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
	
	public void deactivate() {
		activated = false;
		
	}
	
	public boolean isIn(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	@Override
	public String toString() {
		return COIN_SYMBOL;
	}
	
	//Podemos borrarlo?
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
