package com.app.model;

import java.time.LocalDateTime;

public class LoanApplianceResultDTO {
	private int loanId;  
	 private Integer noofYears;
	 private LocalDateTime startDate;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public Integer getNoofYears() {
		return noofYears;
	}
	public void setNoofYears(Integer noofYears) {
		this.noofYears = noofYears;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	 
}
