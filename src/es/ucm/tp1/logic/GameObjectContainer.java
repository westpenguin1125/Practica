package es.ucm.tp1.logic;
import es.ucm.tp1.logic.gameobjects.GameObject;
import java.util.ArrayList;

public class GameObjectContainer {

	ArrayList<GameObject> objectList;
	
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
	
}