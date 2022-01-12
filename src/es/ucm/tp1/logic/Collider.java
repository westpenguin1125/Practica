package es.ucm.tp1.logic;

import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.gameobjects.Cisterna;

public interface Collider {
	boolean doCollision();

	boolean receiveCollision(Player player);
	
	default boolean receiveCollision(Cisterna cis) {
		return false;
	}

	boolean receiveShoot();

	boolean receiveWave();

	boolean receiveExplosion();

	boolean receiveThunder();
}