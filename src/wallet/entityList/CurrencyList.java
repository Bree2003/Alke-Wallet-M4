package wallet.entityList;

import java.util.ArrayList;
import java.util.List;
import wallet.entities.Currency;

import wallet.interfaces.GetInformation;

public class CurrencyList implements GetInformation<Currency>{
	
	private List<Currency> currencies = new ArrayList<>();
	
	

	public CurrencyList() {
		injectData();
	}

	@Override
	public Currency findByID(int id) {
		for(Currency currency : currencies) {
			if(currency.getId() == id) {
				return currency;
			}
		}
		return null;
	}

	@Override
	public void findAll() {
		for(Currency currency : currencies) {
			System.out.println(currency);
		}
		
	}

	@Override
	public void injectData() {
		Currency dolares = new Currency(1, "Dólares", "USD");
		Currency pesosChilenos = new Currency(2, "Pesos Chilenos", "CLP");
        Currency euros = new Currency(3, "Euros", "EUR");
        Currency librasEsterlinas = new Currency(4, "Libras Esterlinas", "GBP");
        Currency yenesJaponeses = new Currency(5, "Yenes Japoneses", "JPY");
        Currency wonSurcoreano = new Currency(6, "Won Surcoreano", "KRW");

        currencies.add(dolares);
        currencies.add(pesosChilenos);
        currencies.add(euros);
        currencies.add(librasEsterlinas);
        currencies.add(yenesJaponeses);
        currencies.add(wonSurcoreano);
	}

	@Override
	public int size() {
		int count = 0;
		while(count < currencies.size()) {
			count++;
		}
		return count;
	}

}
