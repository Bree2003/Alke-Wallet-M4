package wallet.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectOption {
	
	private Scanner s = new Scanner(System.in);
	private int option;

	public void selectOption() {
		System.out.print("Seleccione una opción: ");
		do {
			try {
				option = s.nextInt();
				if(option < 1 || option > 9) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir la operación a realizar: ");
				continue;
			}
			break;
		} while (!s.hasNextInt() || option < 1 || option > 9);
		
	}

	public int chosenOption() {
		return option;
	}

}
