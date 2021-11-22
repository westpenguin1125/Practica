package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.control.Buyable;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.instantactions.ExplodeAction;

public class Grenade extends GameObject{

	
	final public static String GRENADE_INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around";
	private static final String GRENADE_SYMBOL = "ð";
	//TODO El countDown se resta una vez antes de enseñarlo :(
	private final static int CYCLES_TO_EXPLODE = 4;
	
	private int countDown;
	
	
	public Grenade(Game game, int x, int y) {
		super(game, x, y);
		countDown = CYCLES_TO_EXPLODE;
		symbol = GRENADE_SYMBOL;
	}

	@Override
	public boolean doCollision() {
		return false;
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

	@Override
	public void update() {
		countDown--;
		if(countDown == 0) {
			game.execute(new ExplodeAction(this));
		}
	}

	@Override
	public void onDelete() {
	}

	@Override
	public boolean isAlive() {
		return countDown > 0;
	}

	@Override
	protected String getSymbol() {
		return symbol + String.format("[%d]", countDown);
	}
}
