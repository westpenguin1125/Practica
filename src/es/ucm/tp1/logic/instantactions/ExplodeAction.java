package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Grenade;

public class ExplodeAction implements InstantAction {
	
	private Grenade grenade;
	
	public ExplodeAction(Grenade grenade) {
		this.grenade = grenade;
	}

	@Override
	public void execute(Game game) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				GameObject obj = game.gameObjectIn(i + grenade.getX(), j + grenade.getY());
				if (obj != null && !(i == 0 && j == 0)) {
					obj.receiveExplosion();
				}
			}
		}
	}

}
