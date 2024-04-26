package wallet.entityList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import wallet.createEntities.CreateContact;
import wallet.entities.Contact;
import wallet.interfaces.GetInformation;

public class ContactList implements GetInformation<Contact>{

	private List<Contact> contacts = new ArrayList<>();
	private BankList banks = new BankList();
	private Scanner s = new Scanner(System.in);
	
	@Override
	public Contact findByID(int id) {
		for(Contact contact : contacts) {
			if(contact.getId() == id) {
				return contact;
			}
		}
		return null;
	}

	@Override
	public void findAll() {
		for(Contact contact : contacts) {
			System.out.println(contact.getId() + " " + contact.getName() + " "
			+ contact.getAccountNumber() + " " + banks.findByID(contact.getBankID()).getName());
		}
	}

	@Override
	public void injectData() {
		CreateContact createContact = new CreateContact();
		Contact contact = createContact.createEntity(s);
		
		contacts.add(contact);
		
	}

	@Override
	public int size() {
		int count = 0;
		while(count < contacts.size()) {
			count++;
		}
		return count;
	}

}
