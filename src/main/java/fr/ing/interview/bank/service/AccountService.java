package fr.ing.interview.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.ing.interview.bank.dto.AccountDepot;
import fr.ing.interview.bank.exceptions.AccountNotFoundException;
import fr.ing.interview.bank.interfaces.CalculInterface;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.repository.AccountRepository;

@Service(value = "accountService")
public class AccountService {

	@Autowired
	AccountRepository accountDao;

	public String ajouterArgent(AccountDepot accountDepot) throws AccountNotFoundException {

		Optional<Account> acc = accountDao.findByNum(accountDepot.getNumAccount());
		
		if (acc.isPresent() && accountDepot.getSomme() > 0.01D) {
			CalculInterface addition = (double x, double y) -> x + y;
			double solde = addition.operation(acc.get().getBalance(), accountDepot.getSomme());
			acc.get().setBalance(solde);
			accountDao.saveAndFlush(acc.get());
			return "The account "+accountDepot.getNumAccount()+" is suceffuly updated, the new balance is "+acc.get().getBalance();
		}
		else {
			throw new AccountNotFoundException("Cannot deposit money to this account");
		}

	}

	public String retirerArgent(AccountDepot accountDepot) throws AccountNotFoundException {
		Optional<Account> acc = accountDao.findByNum(accountDepot.getNumAccount());

		if (acc.isPresent() && acc.get().getBalance() >= accountDepot.getSomme()) {
			CalculInterface soustraction = (double x, double y) -> x - y;
			double solde = soustraction.operation(acc.get().getBalance(), accountDepot.getSomme());
			acc.get().setBalance(solde);
			accountDao.saveAndFlush(acc.get());
			return "The account "+accountDepot.getNumAccount()+" is suceffuly updated, the new balance is "+acc.get().getBalance();
			
		} else {
			throw new AccountNotFoundException("Cannot withdraw money from this account");
		}
		// return Optional.empty()
	}

	public Double getBalance(String num) throws AccountNotFoundException {
		Optional<Account> acc = accountDao.findByNum(num);
		if (acc.isPresent()) {
			return acc.get().getBalance();
		}
		else {
			throw new AccountNotFoundException("Account not find,please try to verify the account number");
		}

	
	}

	public List<Account> getAccounts() {
		return accountDao.findAll();
	}

}
