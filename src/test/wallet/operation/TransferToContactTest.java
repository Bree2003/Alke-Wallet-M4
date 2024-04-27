package test.wallet.operation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wallet.entityList.AccountList;
import wallet.operation.TransferToContact;

public class TransferToContactTest {

	private AccountList accounts;
	private TransferToContact transferToContact;
	private Scanner s;

	@BeforeEach
	public void setUp() {
		s = mock(Scanner.class);
		accounts = new AccountList(s);
		when(s.nextInt()).thenReturn(4).thenReturn(5).thenReturn(1).thenReturn(2);
		accounts.injectData();
		accounts.injectData();
		accounts.findByID(1).setBalance(50000.00);

	}
	
	@Test
	public void testCalculateMoney() {
		transferToContact = new TransferToContact(s);
		when(s.nextInt()).thenReturn(1);
		when(s.nextDouble()).thenReturn(5600.00);
		transferToContact.calculateMoney(accounts);
		assertEquals(44400.00,accounts.findByID(1).getBalance());
	}


}
