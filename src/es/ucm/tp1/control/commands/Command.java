package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;

public abstract class Command {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";

	/* @formatter:off */
	protected static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new MoveUpCommand(),
		new MoveDownCommand(),
		new ExitCommand(),
		new ResetCommand(),
		new TestCommand(),
	};
	/* @formatter:on */
	
	public static Command getCommand(String[] commandWords) {
		int i = 0;
		
		while(i < AVAILABLE_COMMANDS.length && 
			  null == AVAILABLE_COMMANDS[i].parse(commandWords))
			i++;
		
		if(i == AVAILABLE_COMMANDS.length) {
			System.out.format("[ERROR]: %s%n%n", UNKNOWN_COMMAND_MSG);
			return null;
		}
		else
			return AVAILABLE_COMMANDS[i];
	}

	private final String name;

	private final String shortcut;

	private final String details;

	private final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game);

	protected boolean matchCommandName(String name) {
		return shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}
	
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", name, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				return this;
			}
		}
		return null;
	}
	
	protected String getHelp(){
		return details + ": " + help;
	}
}
