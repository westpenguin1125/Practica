package es.ucm.tp1.logic;

import es.ucm.tp1.logic.gameobjects.Player;

public interface Collider {
	//TODO ASK Significado de el boolean
	boolean doCollision();

	boolean receiveCollision(Player player);
}
