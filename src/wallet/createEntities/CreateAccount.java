package wallet.createEntities;

import java.util.InputMismatchException;
import java.util.Scanner;

import wallet.entities.Account;
import wallet.entityList.BankList;
import wallet.entityList.CurrencyList;
import wallet.interfaces.CreateEntity;

public class CreateAccount implements CreateEntity<Account>{
	
	private BankList banks = new BankList();
	private CurrencyList currencies = new CurrencyList();
	private int currencyID;
	private int bankID;

	@Override
	public Account createEntity(Scanner s) {
		Account account = new Account();
		System.out.println("Creando nueva cuenta, por default el saldo es 0");
		
		// repeat until the user gives an actual number and a valid number
		System.out.println("Escoga el tipo de moneda: (Ingrese opción 1, 2, ...) ");
		currencies.findAll();
		do {
			try {
				currencyID = s.nextInt();
				if(currencyID < 1 || currencyID > currencies.size()) {
					throw new InputMismatchException();
				}
				account.setCurrencyID(currencyID);
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir el tipo de moneda: ");
				continue;
			}
			break;
		} while(!s.hasNextInt() || currencyID < 1 || currencyID > currencies.size());
		
		// repeat until the user gives an actual number and a valid option
		System.out.println("Escoga el tipo de banco: (Ingrese opción 1, 2, ... ");
		banks.findAll();
		do {
			try {
				bankID = s.nextInt();
				if(bankID < 1 || bankID > banks.size()) {
					throw new InputMismatchException();
				}
				account.setBankID(bankID);
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir el tipo de banco: ");
				continue;
			}
				break;
			} while(!s.hasNextInt() || bankID < 1 || bankID > banks.size());
				
		System.out.println("Se ha creado una nueva cuenta, número de cuenta: " + account.getNumberAccount()
		+ " con saldo $" + account.getBalance());
		return account;
	}

}
