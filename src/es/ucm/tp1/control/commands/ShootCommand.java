package es.ucm.tp1.control.commands;


import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.InstantAction;
import es.ucm.tp1.logic.ShootAction;

public class ShootCommand extends Command {

	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]hoot";

	private static final String SHORTCUT = "s";

	private static final String HELP = "shoot bullet";
	
	//TODO lo relacionado al costen monedas de ejecutar este comando
	
	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.execute(new ShootAction());
		return true;
	}
}