package es.ucm.tp1.view;

import es.ucm.tp1.logic.Game;

public class GameSerializer extends View{
	
	final private static String INITIAL_MSG = "---- ROAD FIGHTER SERIALIZED ----" ;
	
	public GameSerializer(Game game){
		super(game);
	}
	
	private String serializeInfo() {
		StringBuilder buffer = new StringBuilder();
			
		buffer.append("Level: " + game.levelString());
		buffer.append("\nCycles: " + game.getNumCycles());
		buffer.append("\nCoins: " + game.getPlayerCoins());
		if(!game.getTestingFlag())
			buffer.append("\nEllapsedTime: " + elapsedTimeWithFormat());
		
		return buffer.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append(INITIAL_MSG + "\n");
		buffer.append(serializeInfo() + "\n");
		buffer.append("Game Objects: \n");
		buffer.append(game.serialize() + "\n");
			
		return buffer.toString();
	}
}