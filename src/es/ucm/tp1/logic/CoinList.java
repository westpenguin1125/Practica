package es.ucm.tp1.logic;

public class CoinList {

	private Coin coinList[];
	private int numCoins;
	
	public CoinList(int L) {
		
		coinList = new Coin[L];
		numCoins = 0;
		
	}
	
	public int getNumCoins() {
		return numCoins;
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
			if (!coin.equals(c)) {
				aux[i] = coin;
				i++;
			}
		}
		numCoins = i;
		coinList = aux;
	}
	
	public Coin coinIn(Position pos) {
		int i = 0;
		
		while(i < numCoins && !coinList[i].isIn(pos))
			i++;
		
		return (i == numCoins) ? null : coinList[i];
	}

	@Override
	public String toString() {
		//cambiar indice 
		return coinList[0].toString();
	}
}
