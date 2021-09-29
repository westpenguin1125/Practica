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
			if (coin != c) {
				aux[i] = coin;
				i++;
			}
		}
		numCoins = i;
		coinList = aux;
	}
	
}
