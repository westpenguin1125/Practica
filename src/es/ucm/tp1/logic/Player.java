package es.ucm.tp1.logic;

public class Player {

	private Position pos;
	
	private int numCoins;
	
	private Game game;
	
	public Player(Position pos, Game game) {
		
		this.pos = pos;
		
		this.numCoins = 0;
		
		this.game = game;
		
	}
	
	public void moveTo(Position pos) {
		this.pos.moveTo(pos);
	}
	
	public void initialize(Position pos) {
		moveTo(pos);
		numCoins = 0;
	}
}
