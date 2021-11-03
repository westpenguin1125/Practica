package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Player extends GameObject{

	private final String PLAYER_SYMBOL_ALIVE = ">";
	private final String PLAYER_SYMBOL_DEAD= "@";
	private final String PLAYER_INFO = "[Car] the racing car";
	
	private int numCoins;
	private int numLifes;
	
	public Player() {
		objectInfo = PLAYER_INFO;
	}
	
	public Player(Game game, int x, int y) {
		super(game, x, y);
		initialize(x, y);
	}
	
	public void increaseCoins() {
		numCoins++;
	}

	public void decreaseLife() {
		numLifes--;
	}
	
	public void initialize(int x, int y) {
		this.x = x;
		this.y = y;
		
		numCoins = 5;
		numLifes = 1;
	}
	
	public void moveDown() {
		if (y < game.getRoadWidth() - 1) {
			y++;	
		}
	}
	
	public void moveUp() {
		if (y > 0) {
			y--;
		}
	}
	
	public boolean isAlive() {
		return numLifes > 0;
	}
	
	public int getNumCoins() {
		return numCoins;
	}
	
	@Override
	public boolean doCollision() {
		GameObject other = game.gameObjectIn(x, y);
		
		if(other != null)
			return other.receiveCollision(this);
		
		return false;
	}

	@Override
	public void update() {
		x++;
		doCollision();
		if(numLifes == 0)
			kill();
	}
	
	@Override
	protected String getSymbol() {
		return isAlive() ? PLAYER_SYMBOL_ALIVE : PLAYER_SYMBOL_DEAD;
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void onDelete() {
	}
}
