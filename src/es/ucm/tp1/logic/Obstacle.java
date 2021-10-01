package es.ucm.tp1.logic;

public class Obstacle {
	
	final private String OBSTACLE_SYMBOL = "░";

	
	private Position pos;
	private Game game;
	
	public Obstacle(int x, int y, Game game) {
		
		this.pos = new Position(x, y);

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
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			return pos.equals(((Obstacle) obj).pos);
		}
	}
	
}
