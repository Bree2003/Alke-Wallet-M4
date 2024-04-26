package wallet.entities;


public class User{
	
	private final int id;
	private String name;
	
	// help id
	private static int helpID = 0;

	public User() {
		helpID++;
		this.id = helpID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + " " + name;
	}


	

}
