package fr.ing.interview.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	public List<Transaction> findByAccount(Account a);

}
