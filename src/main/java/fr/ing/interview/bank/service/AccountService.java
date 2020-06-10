package fr.ing.interview.bank.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.ing.interview.bank.dto.AccountDepot;
import fr.ing.interview.bank.interfaces.CalculInterface;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.repository.AccountRepository;

@Service(value = "accountService")
public class AccountService {

	@Autowired
	AccountRepository accountDao;

	public Account ajouterArgent(AccountDepot accountDepot) {
		
		Account acc= accountDao.findByNum(accountDepot.getNumAccount());
		if (accountDepot.getSomme() > 0.01D && acc != null ) {
			CalculInterface  addition = (double x , double y) -> x + y; 
			double solde = addition.operation(acc.getBalance(), accountDepot.getSomme());
			acc.setBalance(solde);
			accountDao.saveAndFlush(acc);
		}

		return acc;
	}

	public Account retirerArgent(AccountDepot accountDepot) {
		Account acc = accountDao.findByNum(accountDepot.getNumAccount());

		if (acc.getBalance() >= accountDepot.getSomme() && acc != null) {
			CalculInterface  soustraction = (double x , double y) -> x - y; 
			double solde = soustraction.operation(acc.getBalance(), accountDepot.getSomme());
			acc.setBalance(solde);
			accountDao.saveAndFlush(acc);
		}

		return acc;
	}

	public double getBalance(String num) {
		Account acc = accountDao.findByNum(num);
		return acc.getBalance();
	}

	public List<Account> getAccounts() {
		return accountDao.findAll();
	}

}
