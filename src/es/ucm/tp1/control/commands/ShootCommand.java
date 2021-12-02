package es.ucm.tp1.control.commands;


import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.instantactions.ShootAction;
import es.ucm.tp1.view.GamePrinter;

public class ShootCommand extends Command implements Buyable{

	private static final String ERROR_SHOOT_MSG = "Failed to shoot";
	
	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]hoot";

	private static final String SHORTCUT = "s";

	private static final String HELP = "shoot bullet";
	
	private static final int COST = 1;
	
	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if (buy(game)) {
			game.execute(new ShootAction());
			game.update();
			return true;
		}
		System.out.format("%s %s\n\n", ERROR_PROMPT, ERROR_SHOOT_MSG);
		return false;
	}

	@Override
	public int cost() {
		return COST;
	}
}