package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class ShootAction implements InstantAction{

	@Override
	public void execute(Game game) {
		int i = game.getPlayerX();
		boolean found = false;
		
		while( ( i < game.getVisibility() + game.getPlayerX() ) && !found) {
			GameObject obj = game.gameObjectIn(i, game.getPlayerY());
			if (obj != null)
				found = obj.receiveShoot();
			i++;
		}
	}
}