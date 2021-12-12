package es.ucm.tp1.control.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.SuperCars;
import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;

public class DumpCommand extends Command {
	
	private static final String ERROR_DUMPING_MSG = "An error ocurred on reading a file";
	
	private static final String NAME = "dump";

	private static final String DETAILS = "[d]ump <filename>";

	private static final String SHORTCUT = "d";

	private static final String HELP = "Shows the content of a saved file";
	
	private String filename;
	
	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 2)
				throw new CommandParseException(
						String.format("%s Command %s: %s", ERROR_PROMPT, SHORTCUT, INCORRECT_NUMBER_OF_ARGS_MSG));
			else {
				filename = words[1];
				return this;
			}
		}
		return null;
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		StringBuilder buffer = new StringBuilder();
		
		filename = filename + ".txt";
		
		buffer.append(SuperCars.WELCOME_MSG);
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			
			String line = new String();
			line = bufferedReader.readLine();
			
			while(line != null) {
				buffer.append(line + "\n");
				line = bufferedReader.readLine();
			}
			
			System.out.print(buffer.toString());
		}
		catch (IOException e) {
			throw new CommandExecuteException(ERROR_DUMPING_MSG, e);
		}

		return false;
	}

}
