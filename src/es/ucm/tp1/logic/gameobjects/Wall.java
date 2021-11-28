package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Wall extends Obstacles{

	final public static String WALL_INFO = "[WALL] hard obstacle";
	
	final private static int WALL_RESISTANCE = 3;
	
	final private static int COINS_GIVEN_AT_DEATH = 5;
	
	public Wall(Game game, int x, int y) {
		super(game, x, y);
		numLifes = WALL_RESISTANCE;
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		game.rewardPlayer(COINS_GIVEN_AT_DEATH);
	}
}