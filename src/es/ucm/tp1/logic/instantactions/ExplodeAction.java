package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class ExplodeAction implements InstantAction {

	final private static int RANGE_OF_EXPLOSION = 1;

	private int grenadeX;
	private int grenadeY;

	public ExplodeAction(int x, int y) {
		grenadeX = x;
		grenadeY = y;
	}

	@Override
	public void execute(Game game) {
		for (int i = -RANGE_OF_EXPLOSION; i <= RANGE_OF_EXPLOSION; i++) {
			for (int j = -RANGE_OF_EXPLOSION; j <= RANGE_OF_EXPLOSION; j++) {
				GameObject obj = game.gameObjectIn(i + grenadeX, j + grenadeY);
				if (obj != null && !(i == 0 && j == 0))
					obj.receiveExplosion();
			}
		}
	}
}