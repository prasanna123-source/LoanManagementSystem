package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserLoan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    private int loanId;  
	private String loanType;
    private Double amount;   
    private Integer noofYears;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;
    
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getNoofYears() {
		return noofYears;
	}
	public void setNoofYears(Integer noofYears) {
		this.noofYears = noofYears;
	}
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}     
  	
	
}
