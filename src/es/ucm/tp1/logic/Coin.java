package es.ucm.tp1.logic;

public class Coin {
	
	
	final private String COIN_SYMBOL = "¢";

	private int x;
	private int y;
	
	private Game game;
	
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
	
	public boolean isIn(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	public void deactivate() {
		activated = false;
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
			return (this.x == ((Coin) obj).getX() &&
					this.y == ((Coin) obj).getY());
		}
	}
	
}
