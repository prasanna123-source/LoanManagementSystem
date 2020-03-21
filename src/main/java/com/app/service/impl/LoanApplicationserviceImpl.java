package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.LoanDetails;
import com.app.entity.User;
import com.app.model.LoanApplianceDTO;
import com.app.model.LoanRequest;
import com.app.repository.LoanAccountRepository;
import com.app.repository.LoanDetailsRepository;
import com.app.repository.UserLoanRepository;
import com.app.repository.UserRepository;
import com.app.service.LoanApplicationService;

import antlr.StringUtils;

@Service
@Transactional
public class LoanApplicationserviceImpl implements LoanApplicationService{
    
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	LoanDetailsRepository loanDetailsRepo;
	
	@Autowired
	LoanAccountRepository loanAccountRep;
	
	@Autowired
	UserLoanRepository userLoanRepo;
	
	public LoanDetails saveLoan(LoanApplianceDTO loanApplianceDTO) {
		
		Optional<User> userRes = userRepo.findById(loanApplianceDTO.getUserId());
		LoanDetails loanDetails = new LoanDetails();
		if (loanApplianceDTO != null) {
			userRes.ifPresent(user -> {
				if(loanApplianceDTO.getAmount()!=null)
					loanDetails.setLoanAmount(loanApplianceDTO.getAmount());
				if(loanApplianceDTO.getNoofYears()!=null)
					loanDetails.setDuration(loanApplianceDTO.getNoofYears());
				if (loanApplianceDTO.getRateOfInterest() !=null)
					loanDetails.setInterestRate((loanApplianceDTO.getRateOfInterest()));
					
			});
		LoanDetails response = userLoanRepo.save(mappedData);
		return response;
	}


	@Override
	public List<User> fetLoans() {
		return userDao.findAll();
	}

	public void calculateLoanAmount(LoanDetails loanDetails, LoanRequest request) {
		double emi;
		Integer loanAmt = request.getLoanAmount();
		//Float rate = request.getRateOfInterest();
		Double rate=LoanDetailConstants.RATE_OF_INTEREST;
		Integer tenure = request.getTenure();
		rate = rate / (12 * 100);
		tenure = tenure * 12;
		emi = (loanAmt * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1);
		loanDetails.setEmiAmt(emi);
	}

	public Optional<User> fetchLoan(Integer uid) {
		Optional<User> user = userDao.findById(uid);
		if(user.isPresent()) {
			return user;
		}
		else {
			return null;
		}
	}

	
}
