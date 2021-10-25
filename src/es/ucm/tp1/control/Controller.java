package es.ucm.tp1.control;

import java.util.Iterator;
import java.util.Scanner;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

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

	private Command toCommand(String userInput) {
		Command comando;
		
		if (userInput.startsWith("h")) 
			comando = Command.HELP;
		else if (userInput.startsWith("i")) 
			comando = Command.INFO;
		else if (userInput.startsWith("q")) 
			comando = Command.UP;
		else if (userInput.startsWith("a")) 
			comando = Command.DOWN;
		else if (userInput.startsWith("n") || userInput.equals("")) 
			comando = Command.FORWARD;
		else if (userInput.startsWith("e")) 
			comando = Command.EXIT;
		else if (userInput.startsWith("r")) 
			comando = Command.RESET;
		else if (userInput.startsWith("t")) 
			comando = Command.TEST;
		else 
			comando = null;
	
		return comando;
	}
	
	public void run() {
		
		Command command;
		
		game.initialize();
		printGame();
		
		while (!endGame) {
			command = toCommand(getUserInput());
			
			if(command == Command.HELP) 
				for (int i = 0; i < HELP.length; i++) 
					System.out.println(HELP[i]);
			else if(command == Command.INFO)
				for (int i = 0; i < INFO.length; i++) 
					System.out.println(INFO[i]);
			else if(command == Command.EXIT) 
				endGame = true;
			else if(command != null){
				if(command == Command.TEST)
					game.toggleTest();
				else if(command == Command.RESET)
					game.initialize();
				else {
					game.update(command);
					game.removeDeadObjects();
					endGame = game.checkEnd();
				}
				printGame();
			}
			else
				//TOASK Está bien aqui? y en GamePrinter?
				System.out.println("[ERROR]: " + UNKNOWN_COMMAND_MSG + "\n");
		}
		
		printEndMessage();
	}
}
