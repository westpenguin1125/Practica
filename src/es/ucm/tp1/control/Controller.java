package es.ucm.tp1.control;

import java.util.Iterator;
import java.util.Scanner;

import es.ucm.tp1.control.commands.Command;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	//TODO tirar
	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobject info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */
	private static final String[] INFO = new String[] {
		"Available objects"	+ ":",
		 "[Car] the racing car",
		 "[Coin] gives 1 coin to the player",
		 "[Obstacle] hits car",
	};
	
	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;

	private boolean endGame;
	
	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
		endGame = false;
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
		
		game.initialize();
		
		while (!endGame) {
			
			if(refreshDisplay)
				printGame();
			refreshDisplay = false;
			
			parameters = getUserInput().toLowerCase().trim().split(" ");
			command = Command.getCommand(parameters);
			
			if(command != null) 
				refreshDisplay = command.execute(game);
		}
		
		printEndMessage();
	}
}
