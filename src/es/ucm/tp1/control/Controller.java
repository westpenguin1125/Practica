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
		"[i]nfo: prints gameobjet info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
	}

	public void printGame() {
		System.out.println(printer);
	}
	

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

	private boolean userAction(String userInput) {
		boolean endGame = false;
		if (userInput.startsWith("h")) {
			
			for (int i = 0; i < HELP.length; i++) {
				System.out.println(HELP[i]);
			}
			
		}
		else if (userInput.startsWith("q")) {
			//TODO coche sube
		}
		else if (userInput.startsWith("a")) {
			//TODO coche baja
		}
		else if (userInput.startsWith("n") || userInput.equals("")) {
			//TODO coche avanza (update)
		}
		else if (userInput.startsWith("e")) {
			endGame = true;
		}
		else if (userInput.startsWith("r")) {
			//TODO reset
		}
		else if (userInput.startsWith("t")) {
			//TODO test mode
		}
		else
			System.out.println(UNKNOWN_COMMAND_MSG);
		
		return endGame;
	}
	
	public void run() {
		
		boolean endGame = false;
		game.initialize();
		
		while (!endGame) {
			
			printGame();
			
			//TODO REVISAR 
			endGame = userAction(scanner.nextLine().toLowerCase());
			
		}
		
		printGame();
		System.out.println(printer.endMessage());
	}
	

}
