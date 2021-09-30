package es.ucm.tp1.logic;

public class Obstacle {
	
	final private String OBSTACLE_SYMBOL = "░";

	
	private Position pos;
	private Game game;
	
	public Obstacle(Position pos, Game game) {
		
		this.pos = pos;

		this.game = game;
	}
	
	public Position getPos() {
		return pos;
	}
	
	public boolean isIn(Position pos) {
		return (this.pos.equals(pos));
	}
	
	public boolean canBeOnTheRoad() {
		//Returns true if any object is on the position pos
		return !game.gameObjIsIn(pos);
	}
	
	@Override
	public String toString() {
		return OBSTACLE_SYMBOL;
	}
	
}
