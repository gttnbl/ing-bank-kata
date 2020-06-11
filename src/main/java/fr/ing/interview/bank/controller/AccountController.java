package fr.ing.interview.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.ing.interview.bank.dto.AccountDepot;
import fr.ing.interview.bank.exceptions.AccountNotFoundException;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	// User Story 1
	@RequestMapping(value = "/ajouterArgent", method = RequestMethod.POST)
	// @PreAuthorize("hasRole('USER')")
	public String ajouterArgent(@RequestBody AccountDepot accountDepot) {

		try {
			return accountService.ajouterArgent(accountDepot);

		} catch (AccountNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
		}
	}

	// User Story 2
	@RequestMapping(value = "/retirerArgent", method = RequestMethod.POST)
	public String retirerArgent(@RequestBody AccountDepot accountDepot) {
		try {
			return accountService.retirerArgent(accountDepot);

		} catch (AccountNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
		}

	}

	// User Story 3
	@RequestMapping(value = "/getBalance", method = RequestMethod.GET)
	public double getBalances(String num) {

		try {
			return accountService.getBalance(num);

		} catch (AccountNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
		}
	}

	@RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}

}
