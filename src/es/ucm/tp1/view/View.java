package es.ucm.tp1.view;

import java.util.Locale;

import es.ucm.tp1.logic.Game;

public class View {

	protected Game game;
	
	public View(Game game) {
		this.game = game;
	}
	
	protected String elapsedTimeWithFormat() {
		return String.format(Locale.FRANCE, "%.02f", ((float)game.getElapsedTime() / 1000));
	}
}
