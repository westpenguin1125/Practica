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

	public void removeDeadObjects() {
		for(int i = 0; i < numCoins; i++)
			if(coinList[i].isDeactivated())
				removeCoin(coinList[i]);
	}
	
	public Coin coinIn(int x, int y) {
		int i = 0;
		
		while(i < numCoins && !coinList[i].isIn(x, y))
			i++;
		
		return (i == numCoins) ? null : coinList[i];
	}
	
	//Podemos borrarlo?
	@Override
	public String toString() {
		return coinList[0].toString();
	}
}
