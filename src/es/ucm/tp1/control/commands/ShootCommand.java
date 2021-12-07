package es.ucm.tp1.control.commands;


import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.NotEnoughCoinsException;
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
	public boolean execute(Game game) throws CommandExecuteException {
		
		try {
			buy(game);
			game.execute(new ShootAction());
			game.update();
		}
		catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", ERROR_SHOOT_MSG), e);
		}
		return true;
	}

	@Override
	public int cost() {
		return COST;
	}
}