package wallet.entities;

public class Currency {

	private final int id;
	private String name;
	private String ISOcode;

	public Currency(int id, String name, String iSOcode) {
		this.id = id;
		this.name = name;
		ISOcode = iSOcode;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getISOcode() {
		return ISOcode;
	}

	public void setISOcode(String iSOcode) {
		ISOcode = iSOcode;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + ISOcode;
	}
	
	
	
}
