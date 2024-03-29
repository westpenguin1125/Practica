package es.ucm.tp1.view;

import java.util.Locale;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.*;
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

	public static String newLine;

	public static String getObjectInfo() {
		StringBuilder buffer = new StringBuilder();

		buffer.append(Player.PLAYER_INFO + newLine);
		buffer.append(Coin.COIN_INFO + newLine);
		buffer.append(Obstacle.OBSTACLE_INFO + newLine);
		buffer.append(Grenade.GRENADE_INFO + newLine);
		buffer.append(Wall.WALL_INFO + newLine);
		buffer.append(Turbo.TURBO_INFO + newLine);
		buffer.append(SuperCoin.SUPERCOIN_INFO + newLine);
		buffer.append(Truck.TRUCK_INFO + newLine);
		buffer.append(Pedestrian.PEDESTRIAN_INFO);

		return buffer.toString();
	}

	private Game game;

	public GamePrinter(Game game) {
		this.game = game;
		margin = StringUtils.repeat(SPACE, MARGIN_SIZE);
		setRoad();
		newLine = System.getProperty("line.separator");
	}

	protected String elapsedTimeWithFormat() {
		return String.format(Locale.FRANCE, "%.02f", ((float) game.getElapsedTime() / 1000));
	}

	protected String getInfo() {
		StringBuilder info = new StringBuilder();

		info.append("Distance: " + game.getRemainingDistance());
		info.append("\nCoins: " + game.getPlayerCoins());
		info.append("\nCycle: " + game.getNumCycles());
		info.append("\nTotal obstacles: " + Obstacle.getNumObstacles());
		info.append("\nTotal coins: " + Coin.getNumCoins());

		if (SuperCoin.isPresent())
			info.append("\nSupercoin is present");
		if (!game.getTestingFlag())
			info.append("\nElapsed Time: " + elapsedTimeWithFormat() + " s");

		return info.toString();
	}

	private void setRoad() {
		String roadBorder = ROAD_BORDER_PATTERN
				+ StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) * game.getVisibility());
		indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE, game.getVisibility() - 1)
				+ laneDelimiter + SPACE;

		indentedLlanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);
	}

	@Override
	public String toString() {

		setRoad();

		StringBuilder str = new StringBuilder();

		str.append(getInfo());

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;

		for (int y = 0; y < game.getRoadWidth(); y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = 0; x < game.getVisibility(); x++) {
				str.append(StringUtils.centre(game.positionToString(x, y), CELL_SIZE)).append(verticalDelimiter);
			}
			if (y < game.getRoadWidth() - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}

	public String endMessage() {

		String s = GAME_OVER_MSG;

		if (game.win())
			s += WIN_MSG;
		else if (!game.playerIsAlive())
			s += CRASH_MSG;
		else
			s += DO_EXIT_MSG;

		return s;
	}
}