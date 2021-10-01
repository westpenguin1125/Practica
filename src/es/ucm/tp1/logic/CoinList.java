package es.ucm.tp1.logic;

public class CoinList {

	private Coin coinList[];
	private int numCoins;
	
	public CoinList(int L) {
		
		coinList = new Coin[L];
		numCoins = 0;
		
	}
	
	public void addCoin(Coin c) {
		
		if (numCoins < coinList.length) {
			coinList[numCoins] = c;
			numCoins++;
		}
	}
	
	public void removeCoin(Coin c) {

		Coin aux[] = new Coin[numCoins];
		int i = 0;
		
		for (Coin coin : coinList) {
			//TODO sobrescribir el metodo equals de la clase Coin para que se pueda hacer de forma correcta esta comparación
			if (coin != c) {
				aux[i] = coin;
				i++;
			}
		}
		numCoins = i;
		coinList = aux;
	}
	
	public boolean someIn(Position pos) {
		int i = 0;
		
		while(i < numCoins && !coinList[i].isIn(pos))
			i++;
		
		return !(i == numCoins);
	}
	
	public void tryToAdd(Coin c) {
		if(c.canBeOnTheRoad())
			addCoin(c);
	}

	@Override
	public String toString() {
		return coinList[0].toString();
	}
}
