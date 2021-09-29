package es.ucm.tp1.logic;

public class Position {
	private int x, y;
	
	public Position (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void moveTo(Position pos) {
		this.x = pos.getX();
		this.y = pos.getY();
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
			Position aux = (Position) obj;
			return (x == aux.x && y == aux.y);
		}
	}
}
