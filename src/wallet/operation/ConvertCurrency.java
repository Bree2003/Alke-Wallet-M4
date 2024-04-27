package wallet.operation;

import java.util.InputMismatchException;
import java.util.Scanner;

import wallet.convertCurrency.ChileanCurrency;
import wallet.convertCurrency.DollarCurrency;
import wallet.convertCurrency.EuroCurrency;
import wallet.convertCurrency.JapaneseYenCurrency;
import wallet.convertCurrency.PoundSterlingCurrency;
import wallet.convertCurrency.SouthKoreanWonCurrency;
import wallet.entityList.AccountList;

public class ConvertCurrency {
	
	private Scanner s;
	private int option;
	private int account;
	private int accountID;
	private int currencyID;
	private double exchange;
	
	public ConvertCurrency(Scanner s) {
		this.s = s;
	}

	public double convertCurrency(AccountList accounts) {
		
		//choose option
		selectOption(accounts);
		
		switch(option) {
		case 1:
			DollarCurrency dollar = new DollarCurrency(s);
			exchange = dollar.convertCurrency(accounts, accountID, currencyID);
			break;
		case 2:
			ChileanCurrency chilean = new  ChileanCurrency(s);
			exchange = chilean.convertCurrency(accounts, accountID, currencyID);
			break;
		case 3:
			EuroCurrency euro = new  EuroCurrency(s);
			exchange = euro.convertCurrency(accounts, accountID, currencyID);
			break;
		case 4:
			PoundSterlingCurrency poundSterling = new  PoundSterlingCurrency(s);
			exchange = poundSterling.convertCurrency(accounts, accountID, currencyID);
			break;
		case 5:
			JapaneseYenCurrency japaneseYen = new  JapaneseYenCurrency(s);
			exchange = japaneseYen.convertCurrency(accounts, accountID, currencyID);
			break;
		case 6:
			SouthKoreanWonCurrency southkoreanWon = new  SouthKoreanWonCurrency(s);
			exchange = southkoreanWon.convertCurrency(accounts, accountID, currencyID);
			break;
		default:
			System.out.println("Opción no válida");
			break;
		}
		
		return exchange;
		
	}
	
	
	private void selectOption(AccountList accounts) {
		accounts.findAll();
		
		// repeat until the user gives an actual number and a valid option
		System.out.print("Escoga cuenta para convertir: ");
		do {
			try {
				this.account = s.nextInt();
				this.accountID = account;
				this.option = accounts.findByID(account).getCurrencyID();
				if(account < 1 || account > accounts.size()) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir cuenta a convertir: ");
				continue;
			}
			break;
		} while (!s.hasNextInt() || account < 1 || account > accounts.size());
		
	}
	

}
