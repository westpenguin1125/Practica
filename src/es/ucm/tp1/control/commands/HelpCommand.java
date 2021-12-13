package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class HelpCommand extends Command {

	private static final String NAME = "help";

	private static final String DETAILS = "[h]elp";

	private static final String SHORTCUT = "h";

	private static final String HELP = "show this help";

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {

		StringBuilder buffer = new StringBuilder();

		buffer.append("Available commands:" + GamePrinter.newLine);
		for (Command command : AVAILABLE_COMMANDS)
			buffer.append(command.getHelp() + GamePrinter.newLine);

		System.out.print(buffer.toString());

		return false;
	}
}