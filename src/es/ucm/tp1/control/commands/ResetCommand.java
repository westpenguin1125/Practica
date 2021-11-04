package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.GameObjectGenerator;
import es.ucm.tp1.control.Level;

public class ResetCommand extends Command {

	private static final String NAME = "reset";

	private static final String DETAILS = "[r]eset";

	private static final String SHORTCUT = "r";

	private static final String HELP = "reset game";

	private Long newSeed;
	private Level newLevel;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		newLevel = null;
		newSeed = null;
	}

	@Override
	protected Command parse(String[] words) {
		if(words.length == 3) {
			if(matchCommandName(words[0])) {
				newSeed = Long.parseLong(words[2]);
				newLevel = Level.valueOfIgnoreCase(words[1]);
				
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
		
		if (newSeed != null && newLevel != null) {
			game.setSeed(newSeed);
			game.setLevel(newLevel);
		}
		
		GameObjectGenerator.reset();
		game.initialize();
		
		return true;
	}
}
