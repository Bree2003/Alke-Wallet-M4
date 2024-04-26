package wallet.entities;

public class Bank {

	private final int id;
	private String name;

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
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
