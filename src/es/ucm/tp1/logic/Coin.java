package es.ucm.tp1.logic;

public class Coin {
	
	
	final private String COIN_SYMBOL = "¢";

	private int x;
	private int y;
	
	private Game game;
	
	/*
	 * El número de monedas en el juego conviene que sea un atributo estatico de la clase por que en la practica 2 se tendráun solo array con los distintos objetos
	 * Por tanto no se sabrá que objeto se elimina o agrega.
	 * Para ir modificando este atributo se crean metodos para aumentar o disminuir el valor según se declaren o borren variables
	 * onEnter() y onDelete()
	 */
	
	private boolean activated;
	
	public Coin(int x, int y, Game game) {
		
		this.x = x;
		this.y = y;
		 
		this.game = game;
		
		activated = true;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isDeactivated() {
		return !activated;
	}
	
	public void deactivate() {
		activated = false;
	}
	
	public boolean isIn(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	@Override
	public String toString() {
		return COIN_SYMBOL;
	}
	
	//Podemos borrarlo?
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			return (x == ((Coin) obj).getX() &&
					y == ((Coin) obj).getY());
		}
	}
	
}
