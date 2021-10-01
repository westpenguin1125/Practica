package es.ucm.tp1.logic;

public class Coin {
	
	
	final private String COIN_SYMBOL = "¢";
	
	private Position pos;
	private Game game;
	
	public Coin(int x, int y, Game game) {
		
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
		return COIN_SYMBOL;
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
			return pos.equals(((Coin) obj).pos);
		}
	}
	
}
