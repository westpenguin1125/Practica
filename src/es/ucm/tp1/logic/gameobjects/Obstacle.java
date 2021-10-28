package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Obstacle extends GameObject{
	
	final private String OBSTACLE_SYMBOL = "░";
	final private String OBSTACLE_INFO = "[Obstacle] hits car";
	
	private static int numObstacles;
	
	public Obstacle() {
		objectInfo = OBSTACLE_INFO;
	}
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		symbol = OBSTACLE_SYMBOL;
	}
	
	public static int getNumObstacles() {
		return numObstacles;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.decreaseLife();
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onEnter() {
		numObstacles++;
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}	
	
	//TODO ASK tiene sentido mantener esto? Creo que no
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
