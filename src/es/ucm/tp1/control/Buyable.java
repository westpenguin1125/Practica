package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.logic.Game;

public interface Buyable {
	public int cost();

	default void buy(Game game) throws NotEnoughCoinsException {
			//TODO: Aquí el profe pone un método en vez de poner así la lógica
		if (game.getPlayerCoins() < cost())
			throw new NotEnoughCoinsException("Not enough coins");
		else
			game.buy(cost());
	};
}