package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.CommandParseException;
import es.ucm.tp1.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable {

	private static final String ERROR_ADDING_GRENADE_MSG = "Failed to add grenade";

	private static final String INVALID_POSITION_MSG = "Invalid position.";

	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String SHORTCUT = "g";

	private static final String HELP = "add a grenade in position x, y";

	private final static int COST = 3;

	private int xInput;
	private int yInput;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (words.length == 3 && matchCommandName(words[0])) {

			try {
				xInput = Integer.parseInt(words[1]);
				yInput = Integer.parseInt(words[2]);
			}
			catch (NumberFormatException e) {
				throw new CommandParseException(String.format("%s %s", ERROR_PROMPT, POSITION_ERROR), e);
			}
			return this;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		if (game.isValidEmptyPosition(xInput + game.getPlayerX(), yInput)) {
			try {
				buy(game);
				game.addObject(new Grenade(game, xInput + game.getPlayerX(), yInput));
				game.update();
			}
			catch (NotEnoughCoinsException e) {
				System.out.println(e.getMessage());
				throw new CommandExecuteException(String.format("%s %s", ERROR_PROMPT, ERROR_ADDING_GRENADE_MSG), e);
			}
		}
		else {
			System.out.println(INVALID_POSITION_MSG);
			throw new CommandExecuteException(String.format("%s %s", ERROR_PROMPT, ERROR_ADDING_GRENADE_MSG));
		}

		return true;
	}

	@Override
	public int cost() {
		return COST;
	}
}