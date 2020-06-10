package fr.ing.interview.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ing.interview.bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	
	public Account findByNum(String num);
	

}