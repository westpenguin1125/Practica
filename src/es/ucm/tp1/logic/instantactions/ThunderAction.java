package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.view.GamePrinter;

public class ThunderAction implements InstantAction {

	@Override
	public void execute(Game game) {
		int x = game.getRandomVisibility(), y = game.getRandomLane();
		GameObject obj = game.gameObjectIn(x + game.getPlayerX(), y);
		boolean hit = false;
		
		if(obj != null) 
			hit = obj.receiveThunder();

		GamePrinter.showThunder(x, y, obj, hit);
	}
}