package wallet;

import java.util.Scanner;

import wallet.createEntities.CreateUser;
import wallet.entities.User;
import wallet.entityList.AccountList;
import wallet.entityList.BankList;
import wallet.entityList.ContactList;
import wallet.entityList.CurrencyList;
import wallet.menu.Menu;


public class Main {

	public static void main(String[] args) {
		runProgram();
	}
	
	public static void runProgram() {
		Scanner s = new Scanner(System.in);
		CreateUser createUser = new CreateUser();
		User user = createUser.createEntity(s);
		Menu menu = new Menu(user);
		menu.runMenu();
	}

}
