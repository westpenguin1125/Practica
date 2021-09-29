package es.ucm.tp1.logic;

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
		}
	}
	
	public void removeObstacle(Obstacle o) {
		
		Obstacle aux[] = new Obstacle[numObstacles];
		int i = 0;
		
		for (Obstacle obstacle : obstacleList) {
			//TODO sobrescribir el metodo equals de la clase Obstacle para que se pueda hacer de forma correcta esta comparación
			if (obstacle != o) {
				aux[i] = obstacle;
				i++;
			}
		}
		numObstacles = i;
		obstacleList = aux;
	}
	
	public boolean someIn(Position pos) {
		int i = 0;
		
		while(i < numObstacles && !obstacleList[i].isIn(pos))
			i++;
		
		return !(i == numObstacles);
	}

	public void tryToAddIn(Obstacle o) {
		if(o.canBeOnTheRoad())
			addObstacle(o);
	}
	
}
