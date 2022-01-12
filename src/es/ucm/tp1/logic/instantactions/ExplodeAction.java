package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class ExplodeAction implements InstantAction {

	final private static int DEFAULT_RANGE_OF_EXPLOSION = 1;

	private int grenadeX;
	private int grenadeY;
	private Integer range;
	
	public ExplodeAction(int x, int y) {
		grenadeX = x;
		grenadeY = y;
		range = null;
	}
	
	public ExplodeAction(int x, int y, int range) {
		this(x, y);
		this.range = range;
	}
	
	private void execute(Game game, int range) {
		for (int i = -range; i <= range; i++) {
			for (int j = -range; j <= range; j++) {
				GameObject obj = game.gameObjectIn(i + grenadeX, j + grenadeY);
				if (obj != null && !(i == 0 && j == 0))
					obj.receiveExplosion();
			}
		}
	}

	@Override
	public void execute(Game game) {
		if(range != null)
			execute(game, range);
		else
			execute(game, DEFAULT_RANGE_OF_EXPLOSION);
	}
}