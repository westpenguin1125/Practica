package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.GameObjectGenerator;
import es.ucm.tp1.control.Level;

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
	protected Command parse(String[] words) {
		if(words.length == 3) {
			if(matchCommandName(words[0])) {
				newLevel = Level.valueOfIgnoreCase(words[1]);
				newSeed = Long.parseLong(words[2]);
				
				return this;
			}
			else
				return null;
		}
		else
			return super.parse(words);
	}

	@Override
	public boolean execute(Game game) {
		
		GameObjectGenerator.reset();
		
		if (newSeed != null && newLevel != null)
			game.initialize(newSeed, newLevel);
		else
			game.initialize();
		
		return true;
	}
}
