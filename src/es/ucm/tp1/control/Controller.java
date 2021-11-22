package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.control.commands.Command;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";
	
	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;
	
	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
	}
	
	private String getUserInput() {
		String userInput;
		
		System.out.println(PROMPT);
		userInput = scanner.nextLine();
		System.out.println("[DEBUG] Executing: " + userInput);
		
		userInput = userInput.toLowerCase();
		
		return userInput;
	}

	private void printGame() {
		System.out.println(printer);
	}

	private void printEndMessage() {
		System.out.println(printer.endMessage());
	}
	
	public void run() {
		
		Command command;
		String[] parameters;
		boolean refreshDisplay = true;
		
		printGame();
		
		while (!game.isFinished()) {
			
			parameters = getUserInput().toLowerCase().trim().split(" ");
			command = Command.getCommand(parameters);
			
			if(command != null)
				refreshDisplay = command.execute(game);
			
			if(refreshDisplay)
				printGame();
			refreshDisplay = false;
		}
		
		printEndMessage();
	}
}
