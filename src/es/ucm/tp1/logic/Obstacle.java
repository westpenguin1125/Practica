package es.ucm.tp1.logic;

public class Obstacle {
	
	private Position pos;
	private Game game;
	
	public Obstacle(Position pos, Game game) {
		
		this.pos = pos;

		this.game = game;
	}
	
	public Position getpos() {
		return pos;
	}
	
	public boolean isIn(Position pos) {
		return (this.pos.equals(pos));
	}
	
	public boolean canBeOnTheRoad(Position pos) {
		//Returns true if any object is on the position pos
		return !game.gameObjIsIn(pos);
	}
	
}
