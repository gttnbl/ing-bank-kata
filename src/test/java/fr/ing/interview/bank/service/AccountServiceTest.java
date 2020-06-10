package fr.ing.interview.bank.service;

import static org.assertj.core.api.Assertions.assertThat;

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

import fr.ing.interview.bank.dto.AccountDepot;
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

	}

	@Test
	public void testAjouterArgent() {

		Mockito.when(accountDAO.findByNum(Mockito.anyString())).thenReturn(acc);
		Mockito.when(accountDAO.saveAndFlush(acc)).thenReturn(acc);
		Account account=accountService.ajouterArgent(accDep);
		assertThat(10000D == account.getBalance());
	}

	@Test
	public void testRetirerArgent() {

		Mockito.when(accountDAO.findByNum(Mockito.anyString())).thenReturn(acc);
		Mockito.when(accountDAO.saveAndFlush(acc)).thenReturn(acc);
		Account account= accountService.retirerArgent(accDep);
		assertThat(10000D == account.getBalance());
	}

	@Test
	public void testGetBalance() {
		Mockito.when(accountDAO.findByNum(Mockito.anyString())).thenReturn(acc);
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
