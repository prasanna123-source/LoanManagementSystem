package com.app.model;

public class LoanEmiDTO {
	private float loanamount;
	private String paiddetails;
	private float balanceLoanAmount;
	public float getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(float loanamount) {
		this.loanamount = loanamount;
	}
	public String getPaiddetails() {
		return paiddetails;
	}
	public void setPaiddetails(String paiddetails) {
		this.paiddetails = paiddetails;
	}
	public float getBalanceLoanAmount() {
		return balanceLoanAmount;
	}
	public void setBalanceLoanAmount(float balanceLoanAmount) {
		this.balanceLoanAmount = balanceLoanAmount;
	}
	
	

}
