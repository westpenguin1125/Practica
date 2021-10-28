package es.ucm.tp1.logic.gameobjects;

//TODO No se sabe si esto se debe hacer. No lo creo
import es.ucm.tp1.logic.Game;

//TODO extends GameObject
public class Player extends GameObject{

	private final String PLAYER_SYMBOL_ALIVE = ">";
	private final String PLAYER_SYMBOL_DEAD= "@";
	private final String PLAYER_INFO = "[Car] the racing car";
	private Game game;
	
	private int x;
	private int y;
	
	private int numCoins;
	private int numLifes;
	
	public Player() {
		objectInfo = PLAYER_INFO;
	}
	
	public Player(Game game, int x, int y) {
		
		this.game = game;
		
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
		y++;
	}
	
	public void moveUp() {
		y--;
	}
	
	public boolean isAlive() {
		return numLifes > 0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getNumCoins() {
		return numCoins;
	}
	
	@Override
	public String toString() {		System.out.println("me he movido lol");

		return (numLifes > 0) ? PLAYER_SYMBOL_ALIVE : PLAYER_SYMBOL_DEAD;
	}
	
	/*
	public void doCollitions() {
		Coin c = game.coinIn(x, y);
		Obstacle o = game.obstacleIn(x, y);
		
		if(c != null) {
			c.deactivate();
			increaseCoins();
		}
		else if(o != null) {
			decreaseLife();
		}
	}
	*/
	
	@Override
	public boolean doCollision() {
		GameObject other = game.gameObjectIn(x, y);
		
		if(other != null)
			return other.receiveCollision(this);
		
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		x++;
		doCollision();

	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
}
