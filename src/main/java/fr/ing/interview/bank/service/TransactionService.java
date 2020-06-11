package fr.ing.interview.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ing.interview.bank.exceptions.AccountNotFoundException;
import fr.ing.interview.bank.interfaces.CalculInterface;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.model.Transaction;
import fr.ing.interview.bank.repository.AccountRepository;
import fr.ing.interview.bank.repository.TransactionRepository;

@Service(value="transactionService")
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionDao;
	
	@Autowired
	AccountRepository accountDao;
	
	
	public List<Transaction> findTransactionByAccount(Account account) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		
        Optional<Account> acc = accountDao.findByNum(account.getNum());
		
		if (acc.isPresent()) {
			return transactionDao.findByAccount(acc.get());
		}
		else {
			throw new AccountNotFoundException("Account not find,please try to verify the account number");

		}
	}
	
	
	public List<Transaction> getalltransaction() {
		
		return transactionDao.findAll();
	}
	
	
	

}
