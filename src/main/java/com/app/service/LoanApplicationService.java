package com.app.service;

import java.util.Optional;

import com.app.entity.User;
import com.app.entity.UserLoan;

public interface LoanApplicationService {
//	User applyForLoan(User user);	
	public Optional<UserLoan> findLoanById(long loanId); 
}
