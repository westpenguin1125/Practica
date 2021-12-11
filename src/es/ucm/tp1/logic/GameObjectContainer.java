package es.ucm.tp1.logic;

import es.ucm.tp1.logic.gameobjects.GameObject;
import java.util.ArrayList;

public class GameObjectContainer {

	private ArrayList<GameObject> objectList;

	public GameObjectContainer() {
		objectList = new ArrayList<>();
	}

	public GameObject gameObjectIn(int x, int y) {

		for (GameObject obj : objectList)
			if (obj.isInPosition(x, y))
				return obj;

		return null;
	}

	public void addObject(GameObject obj) {
		objectList.add(obj);
		obj.onEnter();
	}

	public void forceAddObject(GameObject obj) {
		addObject(obj);
	}

	public void removeDeadObjects() {
		ArrayList<GameObject> aux = new ArrayList<>();

		for (GameObject obj : objectList) {
			if (obj.isAlive())
				aux.add(obj);
			else
				obj.onDelete();
		}

		objectList = aux;
	}

	public void delObjectsInCol(int x) {
		ArrayList<GameObject> aux = new ArrayList<>();

		for (GameObject obj : objectList) {
			if (obj.getX() == x)
				obj.onDelete();
			else
				aux.add(obj);
		}

		objectList = aux;
	}

	public void updateList() {
		for (GameObject obj : objectList)
			obj.update();
	}

	public void empty() {

		for (GameObject obj : objectList)
			obj.onDelete();
		objectList = new ArrayList<>();
	}

	public String serialize(int length, int width) {
		StringBuilder buffer = new StringBuilder();

		for (int i = 0; i < length; i++)
			for (int j = 0; j < width; j++)
				if (gameObjectIn(i, j) != null)
					buffer.append(gameObjectIn(i, j).serialize() + "\n");

		return buffer.toString();
	}

	public String positionToString(int x, int y) {
		StringBuilder buffer = new StringBuilder();
		for (GameObject obj : objectList) {
			if (obj.isInPosition(x, y))
				buffer.append(obj.toString() + " ");
		}
		return buffer.toString();
	}
}