package es.ucm.tp1.logic;

public class Position {
	private int x, y;
	
	public Position (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
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
