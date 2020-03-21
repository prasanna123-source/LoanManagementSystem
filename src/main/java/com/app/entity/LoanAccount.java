package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LoanAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Integer accountId;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "debit")
	private Float debit;

	@Column(name = "credit")
	private Float credit;
	
	@Column(name="balance")
	private Float balance;

	@ManyToOne(optional = false)
	@JoinColumn(name="user_id")
	private User user;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Float getDebit() {
		return debit;
	}

	public void setDebit(Float debit) {
		this.debit = debit;
	}

	public Float getCredit() {
		return credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoanAccount(Integer accountId, String remarks, Float debit, Float credit, Float balance, User user) {
		super();
		this.accountId = accountId;
		this.remarks = remarks;
		this.debit = debit;
		this.credit = credit;
		this.balance = balance;
		this.user = user;
	}

	public LoanAccount() {		
	}
	

}
