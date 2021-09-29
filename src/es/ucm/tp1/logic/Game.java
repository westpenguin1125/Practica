package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	
	private CoinList coinList;
	private ObstacleList obstacleList;
	
	private long seed;
	private Level level;
	private Player player;

	public Game(long seed, Level level) {
		
		this.seed = seed;
		this.level = level;
		player = new Player(0, level.getRoadWidth() / 2);
		
		coinList = new CoinList(level.getRoadLength());
		obstacleList = new ObstacleList(level.getRoadLength());
		
	}
	
	public void initialize() {
		//TODO inicializar con la clase RANDOM usando el seed
	}
	
	public void toggleTest() {
		// TODO 
	}
	
	public int getVisibility() {
		return level.getVisibility();
	}
	
	public int getRoadWidth() {
		return level.getRoadWidth();
	}
	

	public String positionToString(int x, int y) {
		return "";//TODO dibuja el objeto que está en la posición
	}
}
