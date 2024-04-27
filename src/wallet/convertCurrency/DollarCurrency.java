package wallet.convertCurrency;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import wallet.entityList.AccountList;
import wallet.entityList.CurrencyList;
import wallet.interfaces.ConvertCurrency;

public class DollarCurrency implements ConvertCurrency{
	
	private List<Double> currencyExchange = new ArrayList<>();
	private CurrencyList currencies = new CurrencyList();
	private Scanner s;
	
	public DollarCurrency(Scanner s) {
		this.s = s;
		addCurrency();
	}

	@Override
	public double convertCurrency(AccountList accounts, int accountID, int currencyID) {
		currencyID = chooseCurrency(currencies, currencyID);
		double exchange = accounts.findByID(accountID).getBalance() * currencyExchange.get(currencyID-1);
		accounts.findByID(accountID).setBalance(exchange);
		accounts.findByID(accountID).setCurrencyID(currencyID);
		System.out.println("La cuenta tiene un saldo de $" + accounts.findByID(accountID).getBalance()
				+ currencies.findByID(currencyID).getISOcode());
		return exchange;
	}

	@Override
	public void addCurrency() {
		currencyExchange.add(1.0);
		currencyExchange.add(955.36);
		currencyExchange.add(0.93);
		currencyExchange.add(0.80);
		currencyExchange.add(153.19);
		currencyExchange.add(1371.14);
		
	}
	
	@Override
	public int chooseCurrency(CurrencyList currencies, int currencyID) {
		currencies.findAll();
		
		// repeat until the user gives an actual number and a valid option
		System.out.print("Escoga moneda a convertir: ");
		do {
			try {
				currencyID = s.nextInt();
				if(currencyID < 1 || currencyID > currencies.size()) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir moneda a convertir: ");
				continue;
			}
			break;
		} while (!s.hasNextInt() || currencyID < 1 || currencyID > currencies.size());
		
		return currencyID;
				
	}
	

}
