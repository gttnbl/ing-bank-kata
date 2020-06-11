package fr.ing.interview.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.ing.interview.bank.dto.AccountDepot;
import fr.ing.interview.bank.exceptions.AccountNotFoundException;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.service.AccountService;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	
	
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/ajouterArgent", method = RequestMethod.POST)
	public void ajouterArgent(@RequestBody AccountDepot accountDepot) throws AccountNotFoundException {
		 accountService.ajouterArgent(accountDepot);
	}

}
