package test.wallet.createEntities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wallet.createEntities.CreateAccount;
import wallet.entities.Account;

public class CreateAccountTest {

	private Scanner s;
	private CreateAccount createAccount;
	
	@BeforeEach
	public void setUp() {
		s = mock(Scanner.class);
		createAccount = new CreateAccount();
	}

	@Test
	public void testCreateEntity() {
		when(s.nextInt()).thenReturn(4).thenReturn(5);
		Account account = createAccount.createEntity(s);
		assertEquals(4, account.getCurrencyID());
		assertEquals(5, account.getBankID());
	}


}
