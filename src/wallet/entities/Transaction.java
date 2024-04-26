package wallet.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private final int id;
	private TransactionType type;
	private double total;
	private final Date date;
	
	// help id
	private static int helpID = 0;

	public Transaction() {
		helpID++;
		this.id = helpID;
		this.date = new Date();
	}
	
	// formatted date and time method
	private String getFormattedDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(this.date);
	}

	public int getId() {
		return id;
	}

	
	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDate() {
		return getFormattedDateTime();
	}


	@Override
	public String toString() {
		return id + " " + type + " $" + total + " " + getFormattedDateTime();
	}


	
}
