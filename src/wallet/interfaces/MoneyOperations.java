package wallet.interfaces;

import wallet.entityList.AccountList;

public interface MoneyOperations {
	
	public double calculateMoney(AccountList accounts);
	public boolean successfulOperation();
	public void chooseRecipient(AccountList accounts);
}
