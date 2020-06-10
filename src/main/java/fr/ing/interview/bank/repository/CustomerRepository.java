package fr.ing.interview.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ing.interview.bank.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
