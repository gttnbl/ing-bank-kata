package fr.ing.interview.bank.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import fr.ing.interview.bank.model.Account;
import fr.ing.interview.bank.model.Transaction;
import fr.ing.interview.bank.repository.TransactionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TransactionRepository transactionRepository;

	@Test
	public void whenFindByAccount_thenReturnTransactions() {
		// given
		Account account = new Account();
		account.setAccount_id(1);
		account.setNum("FRIT223456");
		entityManager.merge(account);
		entityManager.flush();

		Transaction t1 = new Transaction();
		Transaction t2 = new Transaction();
		t1.setAccount(account);
		t2.setAccount(account);

		entityManager.merge(t1);
		entityManager.flush();
		entityManager.merge(t2);
		entityManager.flush();

		// entityManager.flush();

		// when
		List<Transaction> found = transactionRepository.findByAccount(account);

		// then
		found.stream().forEach(x -> assertThat(x.getAccount().getNum()).isEqualTo(account.getNum()));

	}

}
