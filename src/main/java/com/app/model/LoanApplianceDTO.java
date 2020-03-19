package com.app.model;

import com.app.entity.User;

public class LoanApplianceDTO {
	private String loanType;      
    private Integer noofYears;
    private Double rateOfInterest;
       
    
	private Double amount ;
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Integer getNoofYears() {
		return noofYears;
	}
	public void setNoofYears(Integer noofYears) {
		this.noofYears = noofYears;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
    
}
