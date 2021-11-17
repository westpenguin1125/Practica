package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Wall extends Obstacles{

	final public static String WALL_INFO = "[WALL] hard obstacle";

	
	public Wall(Game game, int x, int y) {
		super(game, x, y);
		
	}

}
