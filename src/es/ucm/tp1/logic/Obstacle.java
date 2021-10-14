package es.ucm.tp1.logic;

public class Obstacle {
	
	final private String OBSTACLE_SYMBOL = "░";

	private static int numObstacles;

	private int x;
	private int y;
	private Game game;
	
	public Obstacle(int x, int y, Game game) {
		
		this.x = x;
		this.y = y;

		this.game = game;
	}
	
	public void onEnter() {
		numObstacles++;
	}
	
	public static int getNumObstacles() {
		return numObstacles;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isIn(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	@Override
	public String toString() {
		return OBSTACLE_SYMBOL;
	}
	
	//Podemos borrarlo?
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			return (x == ((Obstacle) obj).getX() && 
					y == ((Obstacle) obj).getY());
		}
	}
	
}
