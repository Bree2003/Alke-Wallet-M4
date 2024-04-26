package wallet.interfaces;

import wallet.entityList.AccountList;
import wallet.entityList.CurrencyList;

public interface ConvertCurrency {
	public double convertCurrency(AccountList accounts, int accountID, int currencyID);
	public void addCurrency();
	public int chooseCurrency(CurrencyList currencies, int currencyID);
}
