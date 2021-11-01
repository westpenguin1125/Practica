package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;

public class ResetCommand extends Command{

	private static final String NAME = "reset";

	private static final String DETAILS = "[r]eset";

	private static final String SHORTCUT = "r";

	private static final String HELP = "reset game";
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		//game = new Game(seed, level)
		game.initialize();
		return true;
	}


}
