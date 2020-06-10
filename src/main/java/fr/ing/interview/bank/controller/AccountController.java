package fr.ing.interview.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.ing.interview.bank.dto.AccountDepot;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	//User Story 1
	@RequestMapping(value = "/ajouterArgent", method = RequestMethod.POST)
	 //@PreAuthorize("hasRole('USER')")
	public Account ajouterArgent(@RequestBody AccountDepot accountDepot) {
		return accountService.ajouterArgent(accountDepot);
	}

	//User Story 2
	@RequestMapping(value = "/retirerArgent", method = RequestMethod.POST)
	public Account retirerArgent(@RequestBody AccountDepot accountDepot) {
		return accountService.retirerArgent(accountDepot);
	}
	//User Story 3
	@RequestMapping(value = "/getBalance", method = RequestMethod.GET)
	public double getBalances(String num) {
		return accountService.getBalance(num);
	}
	
	@RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
	public List<Account>  getAccounts() {
		return accountService.getAccounts();
	}

}
