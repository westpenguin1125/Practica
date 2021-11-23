package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class ExplodeAction implements InstantAction {
	
	private int grenadeX;
	private int grenadeY;
	
	public ExplodeAction(int x, int y) {
		grenadeX = x;
		grenadeY = y;
	}

	@Override
	public void execute(Game game) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				GameObject obj = game.gameObjectIn(i + grenadeX, j + grenadeY);
				if (obj != null && !(i == 0 && j == 0)) 
					obj.receiveExplosion();
			}
		}
	}
}