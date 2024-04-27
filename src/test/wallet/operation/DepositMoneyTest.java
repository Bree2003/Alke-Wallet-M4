package test.wallet.operation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wallet.entityList.AccountList;
import wallet.operation.DepositMoney;

public class DepositMoneyTest {
	
	private AccountList accounts;
	private DepositMoney depositMoney;
	private Scanner s;

	@BeforeEach
	public void setUp() {
		s = mock(Scanner.class);
		accounts = new AccountList(s);
		when(s.nextInt()).thenReturn(4).thenReturn(5);
		accounts.injectData();
	}
	
	@Test
	public void testCalculateMoney() {
		depositMoney = new DepositMoney(s);
		when(s.nextInt()).thenReturn(1);
		when(s.nextDouble()).thenReturn(5600.00);
		depositMoney.calculateMoney(accounts);
		assertEquals(5600.00,accounts.findByID(1).getBalance());
	}

}
