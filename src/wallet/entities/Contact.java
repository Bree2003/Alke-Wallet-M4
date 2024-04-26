package wallet.entities;



public class Contact{
	
	private final int id;
	private String name;
	private int accountNumber;
	private int bankID;
	
	// help id
	private static int helpID = 0;

	public Contact() {
		helpID++;
		this.id = helpID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + accountNumber + " " + bankID;
	}

	
	
	
}
