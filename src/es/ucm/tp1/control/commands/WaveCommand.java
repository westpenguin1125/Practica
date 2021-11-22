package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.instantactions.WaveAction;

public class WaveCommand extends Command{

	private static final String NAME = "wave";

	private static final String DETAILS = "[W]ave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "do wave";
	
	//TODO lo relacionado al costen monedas de ejecutar este comando
	
	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.execute(new WaveAction());
		return true;
	}
}