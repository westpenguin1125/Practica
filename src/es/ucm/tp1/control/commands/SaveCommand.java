package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.logic.Game;

public class SaveCommand extends Command {

	private static final String NAME = "save";

	private static final String DETAILS = "sa[v]e <filename>";

	private static final String SHORTCUT = "v";

	private static final String HELP = "Save the state of the game to a file.";
	
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		return false;
	}

}
