package wallet.createEntities;

import java.util.Scanner;

import wallet.entities.User;
import wallet.interfaces.CreateEntity;

public class CreateUser implements CreateEntity<User>{
	private String name;
	
	@Override
	public User createEntity(Scanner s) {
		User user = new User();
		System.out.println("Creando nuevo usuario...");
		System.out.print("Ingrese su nombre: ");
		name = s.next();
		user.setName(name);
		
		System.out.println("Bienvenid@ " + user.getName());
		return user;
	}
}
