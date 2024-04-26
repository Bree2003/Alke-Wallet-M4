package wallet.operation;

import java.util.InputMismatchException;
import java.util.Scanner;

import wallet.entityList.AccountList;
import wallet.interfaces.MoneyOperations;

public class TransferToContact implements MoneyOperations{
	
	private int accountID;
	private double amount;
	private double total;
	private boolean wasSuccessful = false;
	private Scanner s = new Scanner(System.in);
	@Override
	public double calculateMoney(AccountList accounts) {
		chooseRecipient(accounts);
		total = accounts.findByID(accountID).getBalance() - amount;
		accounts.findByID(accountID).setBalance(total);
		System.out.println("La cuenta tiene un saldo de $" + accounts.findByID(accountID).getBalance());
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
		System.out.print("Escoga cuenta para transferir: ");
		do {
			try {
				accountID = s.nextInt();
				if(accountID < 1 || accountID > accounts.size()) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir cuenta para transferir: ");
				continue;
			}
			break;
		} while (!s.hasNextInt() || accountID < 1 || accountID > accounts.size());
		System.out.print("Ingrese monto a transferir: ");
		do {
			try {
				this.amount = s.nextDouble();
				if(amount <= 0 || amount > accounts.findByID(accountID).getBalance()) {
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
