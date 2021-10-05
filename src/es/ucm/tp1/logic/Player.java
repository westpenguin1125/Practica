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
	
	public void initialize(int x, int y) {
		moveTo(new Position(x, y));
		numCoins = 0;
	}

	public boolean isIn(Position pos) {
		return this.pos.equals(pos);
	}

	public Position getPos() {
		return pos;
	}
	
	private void moveTo(Position pos) {
		this.pos.moveTo(pos);
	}
		//TOCOMMENT No quedan muy bonitas estas funciones con la clase Position, la verdad
	public void moveForward() {
		moveTo(new Position(pos.getX() + 1, pos.getY()));
	}
	
	public void moveDown() {
		moveTo(new Position(pos.getX(), pos.getY() + 1));
	}
	
	public void moveUp() {
		moveTo(new Position(pos.getX(), pos.getY() - 1));
	}
	
	public void increaseCoins() {
		numCoins++;
	}

	public void decreaseLife() {
		numLifes--;
	}
	
	@Override
	public String toString() {
		return (numLifes > 0) ? PLAYER_SYMBOL_ALIVE : PLAYER_SYMBOL_DEAD;
	}
	
}
