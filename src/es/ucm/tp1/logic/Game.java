package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	
	private CoinList coinList;
	private ObstacleList obstacleList;
	
	private long seed;
	private Level level;
	private Player player;
	
	private boolean testingFlag;

	public Game(long seed, Level level) {
		
		this.seed = seed;
		this.level = level;
		player = new Player(0, level.getRoadWidth() / 2);
		
		coinList = new CoinList(level.getRoadLength());
		obstacleList = new ObstacleList(level.getRoadLength());
	}
	
	public void initialize() {
		//TODO comportamiento necesario para inicializar los atributos de game cuando se use el comando reset o se inicie un juego
		//Estos atributos toman en cuenta el level y la seed para tomar sus valores
		player.initialize(0, getRoadWidth() / 2);
		
	}
	
	public void toggleTest() {
		// TODO comportamiento necesario para actualizar el flag testingFlag cuando se indique por comando
	}
	
	public int getVisibility() {
		return level.getVisibility();
	}
	
	public int getRoadWidth() {
		return level.getRoadWidth();
	}

	public boolean gameObjIsIn(Position pos) {
		return (coinList.coinIn(pos) || obstacleList.obstacleIn(pos));
	}
	
	public String positionToString(int x, int y) {
		//TODO dibuja el objeto que está en la posición
		return "";
	}
}
