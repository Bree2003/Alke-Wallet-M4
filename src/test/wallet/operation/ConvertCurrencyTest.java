package test.wallet.operation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wallet.entityList.AccountList;
import wallet.operation.ConvertCurrency;

public class ConvertCurrencyTest {

	private AccountList accounts;
	private ConvertCurrency convertCurrency;
	private Scanner s;

	@BeforeEach
	public void setUp() {
		s = mock(Scanner.class);
		accounts = new AccountList(s);
		when(s.nextInt()).thenReturn(4).thenReturn(5);
		accounts.injectData();
		accounts.findByID(1).setBalance(50000.00);
	}
	
	@Test
	public void testCalculateMoney() {
		convertCurrency = new ConvertCurrency(s);
		when(s.nextInt()).thenReturn(1).thenReturn(5);
		convertCurrency.convertCurrency(accounts);
		assertEquals(9614500.00,accounts.findByID(1).getBalance());
		assertEquals(5,accounts.findByID(1).getCurrencyID());
	}
}
