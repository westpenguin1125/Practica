package es.ucm.tp1.logic;
import es.ucm.tp1.logic.gameobjects.GameObject;
import java.util.ArrayList;

public class GameObjectContainer {

	private ArrayList<GameObject> objectList;
	
	public GameObjectContainer() {
		objectList = new ArrayList<>();
	}

	public GameObject gameObjectIn(int x, int y) {
		
		for(GameObject obj : objectList)
			if(obj.isInPosition(x, y))
				return obj;
		
		return null;
	}
	
	public void addObject(GameObject obj) {
		objectList.add(obj);
		obj.onEnter();
	}

	public void removeDeadObjects() {
		ArrayList<GameObject> aux = new ArrayList<>();
		
		for(GameObject obj : objectList) {
			if(!obj.isAlive()) {
				obj.onDelete();
				continue;
			}
			aux.add(obj); 
		}
		
		objectList = aux;
	}
	
	public String positionToString(int x, int y) {
		StringBuilder buffer = new StringBuilder();
		for(GameObject obj : objectList) {
			if(obj.isInPosition(x, y))
				buffer.append(obj.toString() + " ");
		}
		return buffer.toString();
	}
}