package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.instantactions.ExplodeAction;

public class Grenade extends GameObject{

	
	final public static String GRENADE_INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around";
	private static final String GRENADE_SYMBOL = "ð";
	private final static int CYCLES_TO_EXPLODE = 4;
	
	private int countDown;
	
	
	public Grenade(Game game, int x, int y) {
		super(game, x, y);
		countDown = CYCLES_TO_EXPLODE;
		symbol = GRENADE_SYMBOL;
	}

	@Override
	public void update() {
		countDown--;
	}

	@Override
	public boolean isAlive() {
		return countDown > 0;
	}

	@Override
	protected String getSymbol() {
		return symbol + String.format("[%d]", countDown);
	}

	@Override
	public void onDelete() {
		game.execute(new ExplodeAction(getX(), getY()));
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public void onEnter() {
	}
}
