package wallet.menu;

import java.util.Scanner;

import wallet.entities.User;
import wallet.entityList.AccountList;
import wallet.entityList.ContactList;
import wallet.entityList.CurrencyList;
import wallet.entityList.TransactionList;

public class Menu {
	
	private int option;
	private Scanner s = new Scanner(System.in);
	private CurrencyList currencies = new CurrencyList();
	private AccountList accounts = new AccountList(s);
	private ContactList contacts = new ContactList(s);
	private TransactionList transactions = new TransactionList();
	
	public Menu(User user) {
		
	}
	
	// execute the program
	public void runMenu() {
		do {
			showMenu();
			selectOption();
			operationMenu(this.option);
			if(this.option != 9) {
				stayInProgram();
			}
		} while (this.option != 9);
	}
	
	// show the menu and options
	private void showMenu() {
		DisplayMenu menu = new DisplayMenu();
		menu.displayMenu();
	}
	
	// select the option we are gonna work with
	private void selectOption() {
		SelectOption option = new SelectOption();
		option.selectOption();
		this.option = option.chosenOption();
	}
	
	// run the operation option
	private void operationMenu(int option) {
		OperationMenu operation = new OperationMenu();
		operation.operations(option, currencies, accounts, contacts, transactions);
	}
	
	private void stayInProgram() {
		String answer;
		// repeat until the user gives an actual number and a valid option
		System.out.println("Quiere seguir en el programa? (y/n)");
		do {
			answer = s.next();
			if(!answer.equals("y") && !answer.equals("n")) {
				System.out.println("Ha ingresado una opción inválida");
				System.out.print("Vuelva a introducir una opción: ");
			}
			if(answer.equals("n")) {
				this.option = 9;
				operationMenu(this.option);
			}
		} while (!answer.equals("y") && !answer.equals("n"));
		
	}
	
}
