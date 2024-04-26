package wallet.entityList;

import java.util.ArrayList;
import java.util.List;

import wallet.entities.Bank;
import wallet.interfaces.GetInformation;

public class BankList implements GetInformation<Bank>{
	
	private List<Bank> banks = new ArrayList<>();
	
	

	public BankList() {
		injectData();
	}

	@Override
	public Bank findByID(int id) {
		for(Bank bank : banks) {
			if(bank.getId() == id) {
				return bank;
			}
		}
		return null;
	}

	@Override
	public void findAll() {
		for(Bank bank : banks) {
			System.out.println(bank);
		}
		
	}

	@Override
	public void injectData() {
		Bank bci = new Bank(1, "Banco de Créditos e Inversiones");
		Bank bancoEstado = new Bank(2, "Banco del Estado de Chile");
		Bank itau = new Bank(3, "Banco Itaú");
		Bank santander = new Bank(4, "Banco Santander");
		Bank scotiabank = new Bank(5, "Scotiabank");
		Bank bbva = new Bank(6, "Banco de Chile");

		banks.add(bci);
		banks.add(bancoEstado);
		banks.add(itau);
		banks.add(santander);
		banks.add(scotiabank);
		banks.add(bbva);		
	}

	@Override
	public int size() {
		int count = 0;
		while(count < banks.size()) {
			count++;
		}
		return count;
	}

}
