package es.ucm.tp1.logic;
import es.ucm.tp1.logic.gameobjects.GameObject;
import java.util.ArrayList;

public class GameObjectContainer {

	private ArrayList<GameObject> objectList;
	
	public GameObjectContainer() {
		objectList = new ArrayList<>();
	}

	public GameObject gameObjectIn(int x, int y) {
		int i = 0;
		
		while(i < objectList.size() && !objectList.get(i).isInPosition(x, y)) 
			i++;
			
		if(i == objectList.size())
			return null;
		else
			return objectList.get(i);
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
}