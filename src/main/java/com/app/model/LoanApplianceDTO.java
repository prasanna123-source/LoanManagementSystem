package com.app.model;

import com.app.entity.User;

public class LoanApplianceDTO {
	private int userId;      
    private Integer noofYears;    
	private Float amount ;
	private Float rateOfInterest;
	private int loan_id;
	private String paidinfo;
	public String getPaidinfo() {
		return paidinfo;
	}
	public void setPaidinfo(String paidinfo) {
		this.paidinfo = paidinfo;
	}
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Integer getNoofYears() {
		return noofYears;
	}
	public void setNoofYears(Integer noofYears) {
		this.noofYears = noofYears;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	
    
}
