package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.instantactions.WaveAction;
import es.ucm.tp1.view.GamePrinter;

public class WaveCommand extends Command implements Buyable{

	private static final String ERROR_WAVE_MSG = "Failed to wave";
	
	private static final String NAME = "wave";

	private static final String DETAILS = "[w]ave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "do wave";
	
	private static final int COST = 5;

	
	
	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if (buy(game)) {
			game.execute(new WaveAction());
			game.update();
			return true;
		}
		else {
			System.out.println(ERROR_PROMPT + ERROR_WAVE_MSG + GamePrinter.newLine);
			return false;
		}
	}

	@Override
	public int cost() {
		return COST;
	}
}