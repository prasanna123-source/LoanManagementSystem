package com.app.service;

import java.util.List;

import com.app.entity.LoanAccount;
import com.app.entity.LoanDetails;
import com.app.entity.User;
import com.app.entity.UserLoan;
import com.app.model.LoanApplianceDTO;
import com.app.model.UserLoanDetails;

public interface LoanApplicationService {
//	User applyForLoan(User user);	
	public LoanDetails applyForLoan(LoanApplianceDTO loanApplianceDTO) ;
	
	public UserLoanDetails EmiDeductionDetails(LoanAccount loanAccount);
	public UserLoan fetchLoan(int uid);
	public List<LoanDetails> getAllLoanDeatils(User uid);
}
