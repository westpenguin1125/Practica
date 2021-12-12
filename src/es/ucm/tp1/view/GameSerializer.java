package es.ucm.tp1.view;

import java.util.Locale;

import es.ucm.tp1.logic.Game;

public class GameSerializer {

	final private static String INITIAL_MSG = "---- ROAD FIGHTER SERIALIZED ----";
	private Game game;

	public GameSerializer(Game game) {
		this.game = game;
	}

	protected String elapsedTimeWithFormat() {
		return String.format(Locale.FRANCE, "%d", (game.getElapsedTime() / 1000));
	}

	private String serializeInfo() {
		StringBuilder buffer = new StringBuilder();

		buffer.append("Level: " + game.levelString());
		buffer.append("\nCycles: " + game.getNumCycles());
		buffer.append("\nCoins: " + game.getPlayerCoins());
		if (!game.getTestingFlag())
			buffer.append("\nEllapsedTime: " + elapsedTimeWithFormat());

		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();

		buffer.append(INITIAL_MSG + "\n");
		buffer.append(serializeInfo() + "\n");
		buffer.append("Game Objects: \n");
		
		for(int i = 0; i < game.getRoadLength(); i++) {
			for(int j = 0; j < game.getRoadWidth(); j++) {
				buffer.append(game.serializeGameObjectsIn(i, j));
			}
		}		

		return buffer.toString();
	}
}