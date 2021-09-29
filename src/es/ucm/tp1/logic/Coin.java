package es.ucm.tp1.logic;

public class Coin {
	
	private Position pos;
	private Game game;
	
	public Coin(int x, int y, Game game) {
		
		this.game = game;
		
		pos = new Position(x, y);
		
	}
	
	public Position getPos() {
		return pos;
	}
}
