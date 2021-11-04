package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.Level;

public class ResetCommand extends Command {

	private static final String NAME = "reset";

	private static final String DETAILS = "[r]eset";

	private static final String SHORTCUT = "r";

	private static final String HELP = "reset game";

	private Level newLevel;
	private Long newSeed;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		newLevel = null;
		newSeed = null;
	}

	@Override
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 1 && words.length != 3) {
				System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				if (words.length == 3) {
					newLevel = Level.valueOfIgnoreCase(words[1]);
					newSeed = Long.parseLong(words[2]);
				}

				return this;
			}
		}

		return null;
	}

	@Override
	public boolean execute(Game game) {
		if (newSeed != null && newLevel != null) {
			game.setSeed(newSeed);
			game.setLevel(newLevel);
		}
		game.initialize();
		return true;
	}

}
