package es.ucm.tp1.logic;

public class Player {

	private final String PLAYER_SYMBOL_ALIVE = ">";
	private final String PLAYER_SYMBOL_DEAD= "@";
	
	private Game game;
	
	private int x;
	private int y;
	
	private int numCoins;
	private int numLifes;
	
	public Player(int x, int y, Game game) {

		this.game = game;
		
		initialize(x, y);
	}
	
	private void increaseCoins() {
		numCoins++;
	}

	private void decreaseLife() {
		numLifes--;
	}
	
	public void initialize(int x, int y) {
		this.x = x;
		this.y = y;
		
		numCoins = 5;
		numLifes = 1;
	}
	
	public void doCollitions() {
		Coin c = game.coinIn(x, y);
		Obstacle o = game.obstacleIn(x, y);
		
		if(c != null) {
			c.deactivate();
			increaseCoins();
		}
		else if(o != null) {
			decreaseLife();
		}
	}
	
	public void moveForward() {
		x++;
	}
	
	public void moveDown() {
		y++;
	}
	
	public void moveUp() {
		y--;
	}
	
	public boolean isAlive() {
		return numLifes > 0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getNumCoins() {
		return numCoins;
	}
	
	public boolean isIn(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	@Override
	public String toString() {
		return (numLifes > 0) ? PLAYER_SYMBOL_ALIVE : PLAYER_SYMBOL_DEAD;
	}
}
