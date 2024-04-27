package test.wallet.createEntities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wallet.createEntities.CreateContact;
import wallet.entities.Contact;

public class CreateContactTest {

	private Scanner s;
	private CreateContact createContact;
	
	@BeforeEach
	public void setUp() {
		s = mock(Scanner.class);
		createContact = new CreateContact();
	}

	@Test
	public void testCreateEntity() {
		when(s.next()).thenReturn("Sabina");
		when(s.nextInt()).thenReturn(10256).thenReturn(-5).thenReturn(5);
		Contact contact = createContact.createEntity(s);
		assertEquals("Sabina", contact.getName());
		assertEquals(10256, contact.getAccountNumber());
		assertEquals(5, contact.getBankID());
	}

}
