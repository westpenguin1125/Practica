package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Grenade;
import es.ucm.tp1.view.GamePrinter;

public class GrenadeCommand extends Command  implements Buyable{
	
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
	protected Command parse(String[] words) {
		if (words.length == 3 && matchCommandName(words[0])) {
			
			try {
				xInput = Integer.parseInt(words[1]);
				yInput = Integer.parseInt(words[2]);
			}
			catch(NumberFormatException e) {
				return null;
			}
			return this;
		}
		else {
			return null;
		}
	}
	
	@Override
	public boolean execute(Game game) {
		
		if(!game.inVisibility(xInput, yInput) ||
			!game.isEmpty(xInput + game.getPlayerX(), yInput)) {
			
			System.out.println(INVALID_POSITION_MSG);
			System.out.format("%s %s\n\n", ERROR_PROMPT, ERROR_ADDING_GRENADE_MSG);
			
			return false;
		}
		else if (buy(game)) {
			
			game.addObject(new Grenade(game, xInput + game.getPlayerX(), yInput));
			game.update();
			return true;
		}
		else {
			System.out.println(ERROR_PROMPT + ERROR_ADDING_GRENADE_MSG + GamePrinter.newLine);
			return false;
		}
	}
	
	@Override
	public int cost() {
		return COST;
	}
}