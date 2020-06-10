package fr.ing.interview.bank.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.model.Transaction;
import fr.ing.interview.bank.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
@ContextConfiguration
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)

public class TransactionServiceTest {

	@InjectMocks
	TransactionService transactionService;
	@Mock
	TransactionRepository transactionDAO;

	Account acc;
	Transaction t1;
	Transaction t2;
	List<Transaction> transac;

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

	}

	@Test
	public void testFindTransactionByAccount() {
		// fail("Not yet implemented");*
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
