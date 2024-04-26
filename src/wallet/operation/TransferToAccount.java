package wallet.operation;

import java.util.InputMismatchException;
import java.util.Scanner;

import wallet.entityList.AccountList;
import wallet.interfaces.MoneyOperations;

public class TransferToAccount implements MoneyOperations{
	
	private int accountSenderID;
	private int accountRecipientID;
	private double amount;
	private double total;
	private boolean wasSuccessful = false;
	private Scanner s = new Scanner(System.in);
	@Override
	public double calculateMoney(AccountList accounts) {
		chooseRecipient(accounts);
		total = accounts.findByID(accountSenderID).getBalance() - amount;
		accounts.findByID(accountSenderID).setBalance(total);
		System.out.println("La cuenta " + accounts.findByID(accountSenderID).getNumberAccount() + " tiene un saldo de $" + accounts.findByID(accountSenderID).getBalance());
		total = amount + accounts.findByID(accountRecipientID).getBalance();
		accounts.findByID(accountRecipientID).setBalance(total);
		System.out.println("La cuenta "  + accounts.findByID(accountRecipientID).getNumberAccount() + " tiene un saldo de $" + accounts.findByID(accountRecipientID).getBalance());
		wasSuccessful = true;
		return amount;
	}
	@Override
	public boolean successfulOperation() {
		return wasSuccessful;
	}
	@Override
	public void chooseRecipient(AccountList accounts) {
		accounts.findAll();
		
		// repeat until the user gives an actual number and a valid option
		System.out.print("Escoga cuenta para la operación: ");
		do {
			try {
				accountSenderID = s.nextInt();
				if(accountSenderID < 1 || accountSenderID > accounts.size()) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir cuenta para la operación: ");
				continue;
			}
			break;
		} while (!s.hasNextInt() || accountSenderID < 1 || accountSenderID > accounts.size());
		System.out.print("Escoga cuenta a transferir: ");
		do {
			try {
				accountRecipientID = s.nextInt();
				if(accountRecipientID < 1 || accountRecipientID > accounts.size()) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir cuenta a transferir: ");
				continue;
			}
			break;
		} while (!s.hasNextInt() || accountRecipientID < 1 || accountRecipientID > accounts.size());
		System.out.print("Ingrese monto a transferir: ");
		do {
			try {
				this.amount = s.nextDouble();
				if(amount <= 0 || amount > accounts.findByID(accountSenderID).getBalance()) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado un monto válido");
				s.nextLine();
				System.out.print("Vuelva a introducir monto a transferir: ");
				continue;
			}
			break;
		} while(!s.hasNextDouble() || !s.hasNextInt() || amount < 1);
	}

}
