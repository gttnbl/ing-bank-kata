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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import fr.ing.interview.bank.dto.AccountDepot;
import fr.ing.interview.bank.exceptions.AccountNotFoundException;
import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
@ContextConfiguration
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class AccountServiceTest {

	@InjectMocks
	AccountService accountService;
	@Mock
	AccountRepository accountDAO;

	Account acc;
	Optional<Account> acctOpt;
	AccountDepot accDep;
	List<Account> result;

	@Before
	public void setUp() {
		acc = new Account();
		acc.setAccount_id(1);
		acc.setNum("FRTST232657");
		acc.setBalance(9000D);
		accDep = new AccountDepot();
		accDep.setNumAccount("FRTST232657");
		accDep.setSomme(1000D);

		result = new ArrayList<>();
		result.add(acc);

		acctOpt = Optional.of(acc);

	}

	@Test
	public void testAjouterArgent() throws AccountNotFoundException {

		Mockito.when(accountDAO.findByNum(Mockito.anyString())).thenReturn(acctOpt);
		Mockito.when(accountDAO.saveAndFlush(acc)).thenReturn(acc);
		String abc = accountService.ajouterArgent(accDep);
		assertThat(10000D == accDep.getSomme());
	}

	@Test
	public void testRetirerArgent() throws AccountNotFoundException {

		Mockito.when(accountDAO.findByNum(Mockito.anyString())).thenReturn(acctOpt);
		Mockito.when(accountDAO.saveAndFlush(acc)).thenReturn(acc);
		String abc = accountService.retirerArgent(accDep);
		assertThat(10000D == accDep.getSomme());
	}

	@Test
	public void testGetBalance() throws AccountNotFoundException {
		Mockito.when(accountDAO.findByNum(Mockito.anyString())).thenReturn(acctOpt);
		double balance = accountService.getBalance("FR77777");
		assertThat(balance == 9000D);

	}

	@Test
	public void testGetAccounts() {
		Mockito.when(accountDAO.findAll()).thenReturn(result);
		List<Account> accounts = accountService.getAccounts();
		assertThat(accounts.get(0).equals(acc));
	}

}
