package es.ucm.tp1.control.commands;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.exceptions.*;

public abstract class Command {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";
	
	protected static final String ERROR_PROMPT = "[ERROR]:";

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
		new ShootCommand(),
		new GrenadeCommand(),		
		new WaveCommand(),
		new SerializeCommand(),
		new ClearCommand(),
		new CheatCommand(),
	};
	/* @formatter:on */
	
	public static Command getCommand(String[] commandWords) throws CommandParseException {
		int i = 0;
		
		try {
			while(i < AVAILABLE_COMMANDS.length && 
				  null == AVAILABLE_COMMANDS[i].parse(commandWords))
				i++;
		} catch (CommandParseException e) {
			System.out.println(e.getMessage());
		}
		//TODO Esto esta bien?
		if(i == AVAILABLE_COMMANDS.length) 
			throw new CommandParseException(String.format("%s %s%n%n", ERROR_PROMPT, UNKNOWN_COMMAND_MSG));
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

	public abstract boolean execute(Game game) throws CommandExecuteException;

	protected boolean matchCommandName(String name) {
		return shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}
	
	protected Command parse(String[] words) throws CommandParseException{
		if (matchCommandName(words[0])) {
			if (words.length != 1) 
				throw new  CommandParseException(String.format("%s Command %s: %s%n%n", ERROR_PROMPT, shortcut, INCORRECT_NUMBER_OF_ARGS_MSG));
			else
				return this;
		}
		return null;
	}
	
	protected String getHelp(){
		return details + ": " + help;
	}
}