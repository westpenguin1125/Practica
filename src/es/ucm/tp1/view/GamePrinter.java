package es.ucm.tp1.view;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.*;


public class GamePrinter {

	private static final String SPACE = " ";

	private static final String VERTICAL_DELIMITER = "|";

	private static final String ROAD_BORDER_PATTERN = "═";

	private static final String LANE_DELIMITER_PATTERN = "─";

	private static final int CELL_SIZE = 7;

	private static final int MARGIN_SIZE = 2;

	private String indentedRoadBorder;

	private String indentedLlanesSeparator;

	private String margin;


	private static final String CRASH_MSG = String.format("Player crashed!%n");

	private static final String WIN_MSG = String.format("Player wins!%n");

	private static final String DO_EXIT_MSG = "Player leaves the game"; 
	
	private static final String GAME_OVER_MSG = "[GAME OVER] "; 
	
	public String newLine; 

	protected Game game;

	public GamePrinter(Game game) {
		this.game = game;

		margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		String roadBorder = ROAD_BORDER_PATTERN + StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) *  game.getVisibility());
		indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE,  game.getVisibility() - 1) + laneDelimiter + SPACE;

		indentedLlanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);
		newLine =  System.getProperty("line.separator");
	}
	
	private String getInfo() {
		//TODO Información inicial
		StringBuilder info = new StringBuilder();
		info.append("Distance: ");
		info.append(game.getRoadLength() - game.getPlayerXPosition());
		info.append(newLine);
		
		info.append("Coins: ");
		info.append(game.getPlayerCoins());
		info.append(newLine);
		
		info.append("Cycle: ");
		info.append(game.getNumCycles());
		info.append(newLine);
		
		info.append("Total obstacles: ");
		info.append(game.getNumObstacles());//hacerlo con statics 
		info.append(newLine);
		
		info.append("Total coins: ");
		info.append(game.getNumCoins());//hacerlo con statics 
		
		if (!game.getTestingFlag()) {
			info.append(newLine);
			info.append("Elapsed Time: ");
			long elapsedTime = game.getElapsedTime();
			info.append(String.format("%.02f", ((float)elapsedTime / 1000)));
			info.append(" s");
		}
		
		return info.toString();
	}
	

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		// Game Status
		
		str.append(getInfo());
		
		// Paint game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;

		for (int y = 0; y < game.getRoadWidth(); y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = 0; x < game.getVisibility(); x++) {
				str.append(StringUtils.centre(game.positionToString(x, y), CELL_SIZE))
						.append(verticalDelimiter);
			}
			if (y <  game.getRoadWidth() - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}
	
	public String endMessage(){
		
		String s = GAME_OVER_MSG;
		
		// TODO your code here
		//Una funcion que valore la informacion de game
		//y devuelva la constante necesaria para informar de un choque, victoria o abandono
		
		return s;
	}



}
