package es.ucm.tp1.logic;

import es.ucm.tp1.logic.gameobjects.Player;

public interface Collider {
	boolean doCollision();

	boolean receiveCollision(Player player);
	
	boolean receiveShoot();
}