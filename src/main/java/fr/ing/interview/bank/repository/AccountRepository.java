package fr.ing.interview.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ing.interview.bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	
	public Optional<Account> findByNum(String num);
	

}
