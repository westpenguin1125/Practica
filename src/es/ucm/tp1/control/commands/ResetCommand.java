package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.SuperCars;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.control.exceptions.CommandParseException;

public class ResetCommand extends Command {

	private static final String NAME = "reset";

	private static final String DETAILS = "[r]eset [<level> <seed>]";

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
	protected Command parse(String[] words) throws CommandParseException {
		if(words.length == 3) {
			if(matchCommandName(words[0])) {
				try {
					newLevel = Level.valueOfIgnoreCase(words[1]);
					if (newLevel != null) {
						newSeed = Long.parseLong(words[2]);
						return this;
					}
					else 
						throw new CommandParseException(String.format("%s Command %s: %s", ERROR_PROMPT, NAME, SuperCars.LEVEL_INFO_MSG));
				} catch (NumberFormatException nfe) {
					throw new CommandParseException(String.format("%s Command %s: %s", ERROR_PROMPT, NAME, SEED_ERROR), nfe);
				}
			}
			else
				return null;
		}
		else
			return super.parse(words);
	}

	@Override
	public boolean execute(Game game) {
		
		if (newSeed != null && newLevel != null) {
			game.initialize(newSeed, newLevel);
			System.out.println("Level: " + newLevel.name());
			System.out.println(SuperCars.SEED_INFO_MSG + newSeed);

		}
		else
			game.initialize();
		
		return true;
	}
}