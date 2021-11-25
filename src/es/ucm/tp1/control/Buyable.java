package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public interface Buyable {
	public int cost();
	
	public default boolean buy(Game game) {
		if (game.buy(cost())) {
			return true;
		} else {
			System.out.println("Not enough coins");
			return false;
		}
	};
}
