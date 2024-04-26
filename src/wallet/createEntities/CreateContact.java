package wallet.createEntities;

import java.util.InputMismatchException;
import java.util.Scanner;

import wallet.entities.Contact;
import wallet.entityList.BankList;
import wallet.interfaces.CreateEntity;

public class CreateContact implements CreateEntity<Contact>{
	
	private BankList banks = new BankList();
	private int accountNumber;
	private int bankID;
	
	@Override
	public Contact createEntity(Scanner s) {
		Contact contact = new Contact();
		System.out.println("Creando nuevo contacto...");
		System.out.print("Introduzca nombre: ");
		contact.setName(s.next());
		
		// repeat until the user gives an actual number
		System.out.print("Introduzca número de cuenta: ");
		do {
			try {
				accountNumber = s.nextInt();
				if(accountNumber <= 0) {
					throw new InputMismatchException();
				}
				contact.setAccountNumber(accountNumber);
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado un número válido");
				s.nextLine();
				System.out.print("Vuelva a introducir el número de cuenta: ");
				continue;
			}
			break;
		} while(!s.hasNextInt() || accountNumber < 1);
		
		// repeat until the user gives an actual number and a valid option
		System.out.println("Escoga el tipo de banco: (Ingrese opción 1, 2, ... ");
		banks.findAll();
		do {
			try {
				bankID = s.nextInt();
				if(bankID < 1 || bankID > banks.size()) {
					throw new InputMismatchException();
				}
				contact.setBankID(bankID);
			} catch (InputMismatchException e) {
				System.out.println("Error: no ha ingresado una opción válida");
				s.nextLine();
				System.out.print("Vuelva a introducir el tipo de banco: ");
				continue;
			}
			break;
		} while(!s.hasNextInt() || bankID < 1 || bankID > banks.size());
		
		
		
		System.out.println("Creaste el contacto " + contact.getName());
		return contact;
	}
	
}
