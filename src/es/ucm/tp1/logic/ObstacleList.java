package es.ucm.tp1.logic;

import es.ucm.tp1.logic.gameobjects.Obstacle;

public class ObstacleList {
	
	private Obstacle obstacleList[];
	private int numObstacles;
	
	public ObstacleList(int L) {
		
		obstacleList = new Obstacle[L];
		numObstacles = 0;
		
	} 
	
	public void addObstacle(Obstacle o) {
		
		if (numObstacles < obstacleList.length) {
			obstacleList[numObstacles] = o;
			numObstacles++;
			o.onEnter();
		}
	}
  
	public Obstacle obstacleIn(int x, int y) {
		int i = 0;
		
		while(i < numObstacles && !obstacleList[i].isInPosition(x, y))
			i++;
		
		return (i == numObstacles) ? null : obstacleList[i];
	}
}
