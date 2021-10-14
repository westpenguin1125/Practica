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
			c.onEnter();
		}
	}
	
	public void removeCoin(Coin c) {

		Coin aux[] = new Coin[numCoins];
		int num = 0;
		
		for (int i = 0; i < numCoins; i++) {
			if (!coinList[i].equals(c)) {
				aux[num] = coinList[i];
				num++;
			}
		}
		
		numCoins = num;
		coinList = aux;
	}

	public void removeDeadObjects() {
		for(int i = 0; i < numCoins; i++) {
			if(coinList[i].isDeactivated()) {
				coinList[i].onDelete();
				removeCoin(coinList[i]);
			}
		}
	}
	
	public Coin coinIn(int x, int y) {
		int i = 0;

		while(i < numCoins && !coinList[i].isIn(x, y))
			i++;
		
		return (i == numCoins) ? null : coinList[i];
	}
}
