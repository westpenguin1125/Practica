package es.ucm.tp1.logic;

public class Obstacle {
	
	private Position pos;
	private Game game;
	
	public Obstacle(int x, int y, Game game) {
		
		this.game = game;
		
		pos = new Position(x, y); 
	
	}
	
	public Position getPos() {
		return pos;
	}
}
