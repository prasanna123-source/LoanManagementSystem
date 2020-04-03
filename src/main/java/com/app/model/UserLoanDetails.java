package com.app.model;

import java.util.List;

import com.app.entity.LoanAccount;

public class UserLoanDetails {
	private int userId;
	private LoanAccount loanAccounts;
	
	private double paidEmiAmount;
	private float avaialbleLoanAmount;
	public float getAvaialbleLoanAmount() {
		return avaialbleLoanAmount;
	}
	public void setAvaialbleLoanAmount(float avaialbleLoanAmount) {
		this.avaialbleLoanAmount = avaialbleLoanAmount;
	}
	public double getPaidEmiAmount() {
		return paidEmiAmount;
	}
	public void setPaidEmiAmount(double paidEmiAmount) {
		this.paidEmiAmount = paidEmiAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LoanAccount getLoanAccounts() {
		return loanAccounts;
	}
	public void setLoanAccounts(LoanAccount loanAccount) {
		this.loanAccounts = loanAccount;
	}

		
	
}
