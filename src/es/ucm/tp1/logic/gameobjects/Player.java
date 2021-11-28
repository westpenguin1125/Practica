package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Player extends GameObject{
	
	public static final String PLAYER_INFO = "[Car] the racing car";

	private final String PLAYER_SYMBOL_ALIVE = ">";
	private final String PLAYER_SYMBOL_DEAD= "@";
	private final int STARTING_LIFES = 1;
	private final int STARTING_COINS = 5;
	
	private int numCoins;
	private int numLifes;
	
	public Player(Game game, int x, int y) {
		super(game, x, y);
		initialize(x, y);
	}
	
	public void initialize(int x, int y) {
		this.x = x;
		this.y = y;
		
		numCoins = STARTING_COINS;
		numLifes = STARTING_LIFES;
	}
	
	private void move(int dx, int dy) {
		doCollision();
		if(isAlive()) {
			x += dx;
			y += dy;
		}
		doCollision();
	}
	
	public void moveDown() {
		if(getY() < game.getRoadWidth() - 1)
			move(1, 1);
		else 
			moveForward();
	}
	
	public void moveUp() {
		if(0 < getY())
			move(1, -1);
		else 
			moveForward();
	}
	
	public void moveForward() {
		move(1, 0);
	}
	
	public boolean buy(int cost) {
		if (numCoins >= cost) {
			decreaseCoins(cost);
			return true;
		}
		else {
			return false;
		}
	}

	public void decreaseLife() {
		numLifes--;
	}
	
	public void jump() {
		x += 3;
	}
	
	public void increaseCoins(int coinsToIncrease) {
		numCoins += coinsToIncrease;
	}
	
	public void decreaseCoins(int coinsToDecrease) {
		numCoins -= coinsToDecrease;
	}

	public void punish() {
		numCoins = 0;
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
	public boolean isAlive() {
		return numLifes > 0;
	}
	
	@Override
	protected String getSymbol() {
		return isAlive() ? PLAYER_SYMBOL_ALIVE : PLAYER_SYMBOL_DEAD;
	}
	
	@Override
	public String toString() {
		return getSymbol();
	}

	@Override
	public void update() {
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}
	
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void onDelete() {
	}
}
