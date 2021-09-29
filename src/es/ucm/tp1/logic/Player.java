package es.ucm.tp1.logic;

public class Player {

	private Position pos;
	private int numCoins;
	
	private Game game;
	
	public Player(int x, int y) {
		
		pos = new Position(x, y);
		this.numCoins = 0;
		
	}
	
	public void moveTo(int x, int y) {
		pos.moveTo(x, y);
		numCoins = 0;
	}
	
}
