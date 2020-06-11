package fr.ing.interview.bank.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.repository.AccountRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AccountRepository accountRepository;

	@Test
	public void whenFindByNum_thenReturnAccount() {
		// given
		Account account = new Account("FRIT223456");
		
		entityManager.merge(account);
		entityManager.flush();

		// when
		Optional<Account> found = accountRepository.findByNum(account.getNum());

		// then
		assertThat(found.get().getNum()).isEqualTo(account.getNum());
	}

}
