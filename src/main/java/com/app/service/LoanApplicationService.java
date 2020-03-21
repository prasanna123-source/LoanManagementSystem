package com.app.service;

import java.util.Optional;

import com.app.entity.LoanDetails;
import com.app.entity.User;
import com.app.entity.UserLoan;
import com.app.model.LoanApplianceDTO;
import com.app.model.LoanRequest;

public interface LoanApplicationService {
//	User applyForLoan(User user);	
	LoanApplianceDTO applyForLoan(LoanApplianceDTO loanApplianceDTO) ;
	public Optional<UserLoan> findLoanById(long loanId);
	LoanDetails saveLoan(LoanRequest request); 
}
