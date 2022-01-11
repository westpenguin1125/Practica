package es.ucm.tp1.logic.instantactions;

import es.ucm.tp1.logic.Game;

public class AdviceDeadMotoAction implements InstantAction{

	@Override
	public void execute(Game game) {
		game.advice();
	}

}
