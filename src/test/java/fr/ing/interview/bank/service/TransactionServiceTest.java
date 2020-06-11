package fr.ing.interview.bank.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import fr.ing.interview.bank.exceptions.AccountNotFoundException;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.model.Transaction;
import fr.ing.interview.bank.repository.AccountRepository;
import fr.ing.interview.bank.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
@ContextConfiguration
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)

public class TransactionServiceTest {

	@InjectMocks
	TransactionService transactionService;
	@Mock
	TransactionRepository transactionDAO;
	
	@Mock
	AccountRepository accountDao;

	Account acc;
	Transaction t1;
	Transaction t2;
	List<Transaction> transac;
	Optional<Account> acctOpt;
	@Before
	public void setUp() {
		acc = new Account();
		acc.setAccount_id(1);
		acc.setNum("FRTST232657");
		acc.setBalance(9000D);
		t1 = new Transaction();
		t2 = new Transaction();
		t1.setAccount(acc);
		t2.setAccount(acc);
		transac = new ArrayList<>();
		transac.add(t1);
		transac.add(t2);
		
		acctOpt = Optional.of(acc);

	}

	@Test
	public void testFindTransactionByAccount() throws AccountNotFoundException {
		// fail("Not yet implemented");*
		Mockito.when(accountDao.findByNum(Mockito.any())).thenReturn(acctOpt);
		Mockito.when(transactionDAO.findByAccount(Mockito.any())).thenReturn(transac);
		
		List<Transaction> transactions = transactionService.findTransactionByAccount(acc);
		assertThat(transactions.get(0).equals(t1));
		assertThat(transactions.get(1).equals(t2));
	}

	@Test
	public void testGetalltransaction() {
		Mockito.when(transactionDAO.findAll()).thenReturn(transac);
		List<Transaction> transactions  = transactionService.getalltransaction();
		assertThat(transactions.get(0).equals(t1));
	}

}
