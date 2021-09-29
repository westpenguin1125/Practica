package es.ucm.tp1.logic;

public class Player {

	private int x, y;
	
	private int numCoins;
	
	private Game game;
	
	public Player(int x, int y, Game game) {
		
		this.x = x; 
		this.y = y;
		
		this.numCoins = 0;
		
		this.game = game;
		
	}
	
	public void initialize(int iniX, int iniY) {
		x = iniX;
		y = iniY;
		
		numCoins = 0;
	}
}
