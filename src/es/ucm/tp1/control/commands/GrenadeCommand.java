package es.ucm.tp1.control.commands;

import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command  implements Buyable{
	
	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String SHORTCUT = "g";

	private static final String HELP = "add a grenade in position x, y";
	
	private final static int COST = 3;
	
	private int xInput;
	private int yInput;
	
	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	protected Command parse(String[] words) {
		if (words.length == 3 && matchCommandName(words[0])) {
			
			try {
				xInput = Integer.parseInt(words[1]);
				yInput = Integer.parseInt(words[2]);
			}
			catch(NumberFormatException e) {
				return null;
			}
			return this;
		}
		else {
			return null;
		}
	}
	
	@Override
	public boolean execute(Game game) {
		
		//TODO ASK si tiene que revisar si está en los límites
		if (buy(game)) {
//			if(!game.inRange(xInput + game.getPlayerX(), yInput)) {
//				//mensaje
//				return false;
//			}
//			else 
			//TODO ASK if not horrible
			if(!game.isEmpty(xInput + game.getPlayerX(), yInput)) {
				return false;
			}
			else {
				game.tryToAddObject(new Grenade(game, xInput + game.getPlayerX(), yInput), 1);
				game.update();
				return true;
			}
		}
			return false;
	}
	
	@Override
	public int cost() {
		return COST;
	}
}
