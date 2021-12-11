package es.ucm.tp1.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GameSerializer;

public class SaveCommand extends Command {

	private static final String ERROR_SAVING_MSG = "Failed to save";
	
	private static final String NAME = "save";

	private static final String DETAILS = "sa[v]e <filename>";

	private static final String SHORTCUT = "v";

	private static final String HELP = "Save the state of the game to a file.";

	private String filename;

	public SaveCommand() {
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
		filename = filename + ".txt";
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
			GameSerializer serializer = new GameSerializer(game);
			bufferedWriter.append(serializer.toString());
			System.out.println("Game succesfully saved in " + filename);
		}
		catch (IOException e) {
			throw new CommandExecuteException(String.format("%s %s", ERROR_PROMPT, ERROR_SAVING_MSG), e);
		}

		return false;
	}

}
