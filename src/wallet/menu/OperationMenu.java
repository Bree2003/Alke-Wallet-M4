package wallet.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import wallet.entities.TransactionType;
import wallet.entityList.AccountList;
import wallet.entityList.ContactList;
import wallet.entityList.CurrencyList;
import wallet.entityList.TransactionList;
import wallet.operation.ConvertCurrency;
import wallet.operation.DepositMoney;
import wallet.operation.TransferToAccount;
import wallet.operation.TransferToContact;
import wallet.operation.WithdrawMoney;

public class OperationMenu {
	
	private Scanner s = new Scanner(System.in);
	private ConvertCurrency convert = new ConvertCurrency(s);
	private DepositMoney depositMoney = new DepositMoney(s);
	private WithdrawMoney withdrawMoney = new WithdrawMoney(s);
	private TransferToAccount transferToAccount = new TransferToAccount(s);
	private TransferToContact transferToContact = new TransferToContact(s);
	
	private double amount;

	public void operations(int option, CurrencyList currencies, AccountList accounts, ContactList contacts,
			TransactionList transactions) {
		
		switch(option) {
		case 1:
			accounts.injectData();
			break;
		case 2:
			contacts.injectData();
			break;
		case 3:
			if(accounts.size() == 0) {
				System.out.println("No hay cuentas, tiene que agregar una.");
				break;
			}
			amount = depositMoney.calculateMoney(accounts);
			if(depositMoney.successfulOperation()) {
				newTransaction(transactions, amount, TransactionType.DEPOSIT);
			}
			break;
		case 4:
			if(accounts.size() == 0) {
				System.out.println("No hay cuentas, tiene que agregar una.");
				break;
			}
			amount = withdrawMoney.calculateMoney(accounts);
			if(withdrawMoney.successfulOperation()) {
				newTransaction(transactions, amount, TransactionType.WITHDRAWAL);	
			}
			break;
		case 5:
			if(accounts.size() == 0) {
				System.out.println("No hay cuentas, tiene que agregar una.");
				break;
			} else if(accounts.size() < 2) {
				System.out.println("No tiene suficientes cuentas para hacer una transferencia");
				break;
			}
			amount = transferToAccount.calculateMoney(accounts);
			if(transferToAccount.successfulOperation()) {
				newTransaction(transactions, amount, TransactionType.TRANSFER);	
			}
			break;
		case 6:
			if(contacts.size() == 0) {
				System.out.println("No hay contactos, tiene que agregar una.");
				break;
			}
			if(accounts.size() == 0) {
				System.out.println("No hay cuentas, tiene que agregar una.");
				break;
			}
			chooseContact(contacts);
			amount = transferToContact.calculateMoney(accounts);
			if(transferToContact.successfulOperation()) {
				newTransaction(transactions, amount, TransactionType.TRANSFER);	
			}
			break;
		case 7:
			if(accounts.size() == 0) {
				System.out.println("No hay cuentas, tiene que agregar una.");
				break;
			}
			amount = convert.convertCurrency(accounts);
			newTransaction(transactions, amount, TransactionType.CONVERSION);
			break;
		case 8:
			transactions.findAll();
			break;
		case 9:
			System.out.println("Saliendo del programa");
			break;
		default:
			System.out.println("Ingresó una opción no válida");
			break;
		}
		
	}
	
	private void newTransaction(TransactionList transactions, double total, TransactionType type) {
		transactions.injectData();
		transactions.findByID(transactions.size()).setTotal(total);
		transactions.findByID(transactions.size()).setType(type);
		System.out.println("Se ha creado una nueva transacción");
	}
	
	private void chooseContact(ContactList contacts) {
		contacts.findAll();
		
		int option = 0;
		// repeat until the user gives an actual number and a valid option
		System.out.print("Escoga contacto a transferir: ");
		do {
			try {
				option = s.nextInt();
				if(option < 1 || option > contacts.size()) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir contacto a transferir: ");
				continue;
			}
			break;
		} while (!s.hasNextInt() || option < 1 || option > contacts.size());
	}


}
