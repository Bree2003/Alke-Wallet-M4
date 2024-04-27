package test.wallet.createEntities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wallet.createEntities.CreateUser;
import wallet.entities.User;

public class CreateUserTest {
	
	private Scanner s;
	private CreateUser createUser;
	
	@BeforeEach
	public void setUp() {
		s = mock(Scanner.class);
		createUser = new CreateUser();
	}

	@Test
	public void testCreateEntity() {
		when(s.next()).thenReturn("Brisa");
		User user = createUser.createEntity(s);
		assertEquals("Brisa", user.getName());
	}

}
