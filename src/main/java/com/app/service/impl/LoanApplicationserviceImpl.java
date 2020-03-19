package com.app.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.entity.User;
import com.app.entity.UserLoan;
import com.app.model.LoanApplianceDTO;
import com.app.repository.UserRepository;
import com.app.service.LoanApplicationService;

@Service
@Transactional
public class LoanApplicationserviceImpl implements LoanApplicationService{
    
	@Autowired
	UserRepository userRepository;
	
	public User applyForLoan(LoanApplianceDTO loanApplianceDTO) {
		Double loanAmount=loanApplianceDTO.getAmount();
		int duration=loanApplianceDTO.getNoofYears();
		long loanId = System.currentTimeMillis();

		Object loanRequestDTO;
		int userId = ((Object) loanRequestDTO).getUserId();

		Optional<User> user = userRepository.findById(userId);
		UserLoan loan = ((Object) UserLoan.builder()).loanId(loanId).principal(loanAmount).interest(interestRate).balance(loanAmount)
				.emi(emi).user(user.get()).build();

//		UserLoan savedLoan = userRepository.save(loan);
		return userRepository.saveAll(loanApplianceDTO);		
	}

	@Override
	public Optional<UserLoan> findLoanById(long loanId) {
		  return userRepository.findByPk(loanId);
	}
	
}
