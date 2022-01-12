package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Player extends GameObject {

	public static final String PLAYER_INFO = "[Car] the racing car";

	private final String PLAYER_SYMBOL_ALIVE = ">";
	private final String PLAYER_SYMBOL_DEAD = "@";
	private final int STARTING_LIFES = 1;
	private final int STARTING_COINS = 5;

	private int numCoins;
	private int numLifes;
	
	private int driftingCycles;

	public Player(Game game, int x, int y) {
		super(game, x, y);
		initialize(x, y);
		driftingCycles = 0;
	}

	public void initialize(int x, int y) {
		this.x = x;
		this.y = y;

		numCoins = STARTING_COINS;
		numLifes = STARTING_LIFES;
	}

	private void move(int dx, int dy) {
		doCollision();
		if (isAlive() && !drifting()) {
			x += dx;
			y += dy;
		}
		else if(drifting())
			moveDrifting();
		doCollision();
	}

	public void moveDown() {
		if (getY() < game.getRoadWidth() - 1)
			move(1, 1);
		else
			moveForward();
	}

	public void moveUp() {
		if (0 < getY())
			move(1, -1);
		else
			moveForward();
	}

	public void moveForward() {
		move(1, 0);
	}

	public void buy(int cost) {
		decreaseCoins(cost);
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

	public void drift(int numCycles) {
		driftingCycles = numCycles;
	}
	
	private int getRandomDir() {
		double prob = game.getRandomNumber();
		int dir;
		
		if(prob < 0.33)
			dir = 1;
		else if(prob < 0.66)
			dir = 0;
		else
			dir = -1;
		
		System.out.println("[DEBUG] cars drifting: " + dir);
		
		return dir;
	}
	
	private void moveDrifting() {
		int dir = getRandomDir();
		if(game.inValidPosition(x, y + dir))
			y += dir;
		x += 1;
		
		driftingCycles--;
	}
	
	public boolean drifting() {
		return driftingCycles > 0;
	}
	
	@Override
	public boolean doCollision() {
		GameObject other = game.gameObjectIn(x, y);

		if (other != null)
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
		driftingCycles--;
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