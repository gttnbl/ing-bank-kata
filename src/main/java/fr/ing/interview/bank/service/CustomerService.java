package fr.ing.interview.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ing.interview.bank.model.Customer;
import fr.ing.interview.bank.repository.CustomerRepository;

@Service(value="customerService")
public class CustomerService{

	@Autowired
	CustomerRepository customerDao;
	
	
	public void testGetCustomer(int id) {
		// TODO Auto-generated method stub
		customerDao.findById(id);
		System.out.println("Hello from service testGetCustomer");
	}
	
	public void saveCust(Customer customer) {
		customerDao.save(customer);
	}
	
	public List<Customer> getAll() {
		return customerDao.findAll();
	}

}
