package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LoanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_details_id")
	private Integer loanDetailsId;

	@Column(name = "loan_amount")
	private Float loanAmount;
	
	@Column(name = "emi_Amount")
	private double emiAmount;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "interest_rate")
	private Float interestRate;

	@Column(name = "status")
	private String status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "loan_id")
	private UserLoan loan;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	public Integer getLoanDetailsId() {
		return loanDetailsId;
	}

	public void setLoanDetailsId(Integer loanDetailsId) {
		this.loanDetailsId = loanDetailsId;
	}

	public Float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserLoan getLoan() {
		return loan;
	}

	public void setLoan(UserLoan loan) {
		this.loan = loan;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emi) {
		this.emiAmount = emi;
	}


	public LoanDetails(Integer loanDetailsId, Float loanAmount, double emiAmount, Integer duration,
			Float interestRate, String status, UserLoan loan, User user) {
		super();
		this.loanDetailsId = loanDetailsId;
//		this.loanId = loanId;
		this.loanAmount = loanAmount;
		this.emiAmount = emiAmount;
		this.duration = duration;
		this.interestRate = interestRate;
		this.status = status;
		this.loan = loan;
		this.user = user;
	}

	public LoanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
