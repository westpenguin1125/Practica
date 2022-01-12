package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class SonicBlastAction implements InstantAction{
	int lane;
	
	public SonicBlastAction(int lane){
		this.lane = lane;
	}
	
	@Override
	public void execute(Game game) {
		int x = game.getPlayerX();
		GameObject obj = game.gameObjectIn(game.getPlayerX(), lane);
		boolean nonObstacleReceiving = false;
		
		while(x <= game.lastColumnVisible() && !nonObstacleReceiving) {
			obj = game.gameObjectIn(x, lane);
			if(obj != null)
				nonObstacleReceiving = !obj.receiveSonicBlast();
			x++;
		}
	}

}
