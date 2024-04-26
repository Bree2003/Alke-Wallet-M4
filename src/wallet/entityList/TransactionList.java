package wallet.entityList;

import java.util.ArrayList;
import java.util.List;

import wallet.entities.Transaction;
import wallet.interfaces.GetInformation;

public class TransactionList implements GetInformation<Transaction>{

	private List<Transaction> transactions = new ArrayList<>();
	
	@Override
	public Transaction findByID(int id) {
		for(Transaction transaction : transactions) {
			if(transaction.getId() == id) {
				return transaction;
			}
		}
		return null;
	}

	@Override
	public void findAll() {
		for(Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}

	@Override
	public void injectData() {
		Transaction transaction = new Transaction();
		transactions.add(transaction);
		
	}

	@Override
	public int size() {
		int count = 0;
		while(count < transactions.size()) {
			count++;
		}
		return count;
	}

}
