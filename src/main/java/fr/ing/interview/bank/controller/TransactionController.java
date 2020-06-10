package fr.ing.interview.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.model.Transaction;
import fr.ing.interview.bank.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	
	//User Story 4
	@RequestMapping(value = "/getAccountTransactions", method = RequestMethod.POST)
	public List<Transaction> findTransactionsByAccount(@RequestBody  Account account) {
		return transactionService.findTransactionByAccount(account);
	}

	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Transaction> getall() {
		return transactionService.getalltransaction();
	}
	
}
