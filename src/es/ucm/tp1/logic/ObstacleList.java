package es.ucm.tp1.logic;

public class ObstacleList {
	
	private Obstacle obstacleList[];
	private int numObstacles;
	
	
	public ObstacleList(int L) {
		
		obstacleList = new Obstacle[L];
		numObstacles = 0;
		
	}
	//TODO mirar tipo parametros y tipo aux está mal eeeeee
public void addObstacle(Obstacle c) {
		
		if (numObstacles < obstacleList.length) {
			obstacleList[numObstacles] = c;
			numObstacles++;
		}
	}
	
	public void removeCoin(Coin c) {
		Coin aux[] = new Coin[numObstacles];
		int i = 0;
		for (Coin obstacle : obstacleList) {
			if (obstacle != c) {
				aux[i] = obstacle;
				i++;
			}
		}
		numObstacles = i;
		obstacleList = aux;
		
	}
	
}
