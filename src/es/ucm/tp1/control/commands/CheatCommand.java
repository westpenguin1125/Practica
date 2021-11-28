package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.GameObjectGenerator;

public class CheatCommand extends Command{
	private static final String NAME = "Cheat";

	private static final String DETAILS = "Cheat [1..5]";

	private static final String SHORTCUT = "";

	private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";
	
	private int id;
	
	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		GameObjectGenerator.forceAdvanceObject(game, id, game.lastColumnVisible());
		return true;
	}
	
	@Override
	protected Command parse(String[] words) {
		if(words.length > 1)
			return null;
		try {
			id = Integer.parseInt(words[0]);
			if(id < GameObjectGenerator.MIN_ID || id > GameObjectGenerator.MAX_ID)
				return null;
		}	
		catch (NumberFormatException e){
			return null;
		}
		return this;
	}
}
