package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="loan")
public class UserLoan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)      
	private Integer id;
    private int loanId;  
	private String loanType;
    private Double amount;   
    private Integer noofYears;   	
	private Float interest;	
	private Float balance;	
	private Float emi;
		   
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
    private User user;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getNoofYears() {
		return noofYears;
	}

	public void setNoofYears(Integer noofYears) {
		this.noofYears = noofYears;
	}

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Float getEmi() {
		return emi;
	}

	public void setEmi(Float emi) {
		this.emi = emi;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserLoan(Integer id, int loanId, String loanType, Double amount, Integer noofYears, Float interest,
			Float balance, Float emi, User user) {
		super();
		this.id = id;
		this.loanId = loanId;
		this.loanType = loanType;
		this.amount = amount;
		this.noofYears = noofYears;
		this.interest = interest;
		this.balance = balance;
		this.emi = emi;
		this.user = user;
	}

	public UserLoan() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	
  	
	
}
