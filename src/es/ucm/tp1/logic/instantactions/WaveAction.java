package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class WaveAction implements InstantAction {

	@Override
	public void execute(Game game) {
		int lastColPos = game.getPlayerX() + game.getVisibility() - 1;

		for (int i = lastColPos; game.getPlayerX() <= i; i--) {

			for (int j = 0; j < game.getRoadWidth(); j++) {
				GameObject obj = game.gameObjectIn(i, j);

				if (obj != null && game.isEmpty(i + 1, j))
					obj.receiveWave();
			}
		}
	}
}