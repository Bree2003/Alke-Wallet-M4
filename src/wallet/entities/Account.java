package wallet.entities;

public class Account {

	private final int id;
	private final int numberAccount;
	private double balance;
	private int currencyID;
	private int bankID;
	
	
	// help id and help number account
	private static int helpID = 0;
	private static int helpNumberAccount = 1000;
	
	public Account() {
		helpID++;
		helpNumberAccount++;
		this.id = helpID;
		this.numberAccount = helpNumberAccount;
		this.balance = 0.0;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCurrencyID() {
		return currencyID;
	}

	public void setCurrencyID(int currencyID) {
		this.currencyID = currencyID;
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

	public int getNumberAccount() {
		return numberAccount;
	}

	@Override
	public String toString() {
		return id + " " + numberAccount + " " + balance + " "
				+ currencyID + " " + bankID;
	}
	
	
}
