package wallet.entityList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import wallet.createEntities.CreateAccount;
import wallet.entities.Account;
import wallet.interfaces.GetInformation;

public class AccountList implements GetInformation<Account>{
	
	private List<Account> accounts = new ArrayList<>();
	private BankList banks = new BankList();
	private CurrencyList currencies = new CurrencyList();
	private Scanner s;

	public AccountList(Scanner s) {
		this.s = s;
	}

	@Override
	public Account findByID(int id) {
		for(Account account : accounts) {
			if(account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	@Override
	public void findAll() {
		for(Account account : accounts) {
			System.out.println(account.getId() + " " + account.getNumberAccount() + " $" + account.getBalance()
			+ " " + currencies.findByID(account.getCurrencyID()).getISOcode() + " " + banks.findByID(account.getId()).getName());
		}
		
	}

	@Override
	public void injectData() {
		CreateAccount createAccount = new CreateAccount();
		Account account = createAccount.createEntity(s);
		
		accounts.add(account);
		
	}

	@Override
	public int size() {
		int count = 0;
		while(count < accounts.size()) {
			count++;
		}
		return count;
	}

}
