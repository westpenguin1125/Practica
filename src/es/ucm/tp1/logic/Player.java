package es.ucm.tp1.logic;

public class Player {

	private final String PLAYER_SYMBOL_ALIVE = ">";
	private final String PLAYER_SYMBOL_DEAD= "@";

	
	private Position pos;
	
	private int numCoins;
	private int numLifes;
	
	private Game game;
	
	public Player(int x, int y, Game game) {
		
		this.pos = new Position(x, y);
		
		numCoins = 0;
		numLifes = 1;
		this.game = game;
		
	}
	
	public void moveTo(Position pos) {
		this.pos.moveTo(pos);
	}
	
	public void initialize(Position pos) {
		moveTo(pos);
		numCoins = 0;
	}

	public boolean isIn(int x, int y) {
		return pos.equals(new Position(x, y));
	}
	
	@Override
	public String toString() {
		return (numLifes > 0) ? PLAYER_SYMBOL_ALIVE : PLAYER_SYMBOL_DEAD;
	}

	public Position getPos() {
		return pos;
	}

	public void increaseCoins() {
		numCoins++;
	}

	public void decreaseLife() {
		numLifes--;
		
	}
	
}
