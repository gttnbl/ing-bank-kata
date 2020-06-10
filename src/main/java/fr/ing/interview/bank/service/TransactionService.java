package fr.ing.interview.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.model.Transaction;
import fr.ing.interview.bank.repository.TransactionRepository;

@Service(value="transactionService")
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionDao;
	
	
	public List<Transaction> findTransactionByAccount(Account account) {
		// TODO Auto-generated method stub
		 List<Transaction> transactions = transactionDao.findByAccount(account);
		 return transactions;
	}
	
	
	public List<Transaction> getalltransaction() {
		
		return transactionDao.findAll();
	}
	
	
	

}
