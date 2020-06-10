package fr.ing.interview.bank.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import fr.ing.interview.bank.enums.EtatTransaction;
import fr.ing.interview.bank.enums.TypeTransaction;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	@Column(name = "DATE_TRANSACTION")
	private Date date;
	@Column(name = "TYPE_TRANSACTION")
	private TypeTransaction type;
	@Column(name = "ETAT")
	private EtatTransaction etat;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}

	public EtatTransaction getEtat() {
		return etat;
	}

	public void setEtat(EtatTransaction etat) {
		this.etat = etat;
	}

}
