package fr.ing.interview.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.ing.interview.bank.model.Customer;
import fr.ing.interview.bank.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/prod", method = RequestMethod.GET)
	public Customer testCustomer() {
		customerService.testGetCustomer(5);
		Customer c = new Customer("Nabil", "Guetet");
		return c;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer c) {
		customerService.saveCust(c);
		return c;
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Customer>  getall() {
		return customerService.getAll();
	
	}

}
