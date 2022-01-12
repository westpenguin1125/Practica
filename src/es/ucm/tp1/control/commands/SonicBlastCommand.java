package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.CommandParseException;
import es.ucm.tp1.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.instantactions.SonicBlastAction;

public class SonicBlastCommand extends Command implements Buyable{
	
	private static final String ERROR_SONICBLAST_MSG = "Failed to blast";
	
	private static final String NAME = "SonicBlast";

	private static final String DETAILS = "[bs]SonicBlast y";

	private static final String SHORTCUT = "bs";

	private static final String HELP = "finds the first obj in the lane y and if its a Obstacle kills it, rewards the Player and looks for the next one, if its any other GameObject it will stop looking for";

	private static final int COST = 3;
	
	private int lane;
	
	public SonicBlastCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public int cost() {
		return COST;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		
		try {
			buy(game);
			game.execute(new SonicBlastAction(lane));
			game.removeDeadObjects();
		}
		catch(NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("%s %s", ERROR_PROMPT, ERROR_SONICBLAST_MSG), e);
		}
		
		return true;
	}
	
	@Override
	public Command parse(String[] words) throws CommandParseException{
		if(matchCommandName(words[0])) {
			if(words.length == 2) {
				try {
					lane = Integer.parseInt(words[1]);
					return this;
				}
				catch (NumberFormatException nfe) {
					throw new CommandParseException(String.format("%s Command %s: %s", ERROR_PROMPT, SHORTCUT, POSITION_ERROR), nfe);
				}
			}
			else
				throw new CommandParseException(String.format("%s Command %s: %s", ERROR_PROMPT, SHORTCUT, INCORRECT_NUMBER_OF_ARGS_MSG));
		}
		else
			return null;
	}
	
}
