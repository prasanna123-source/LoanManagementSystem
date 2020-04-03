package com.app.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.constants.LoanDetailConstants;
import com.app.entity.LoanAccount;
import com.app.entity.LoanDetails;
import com.app.entity.User;
import com.app.entity.UserLoan;
import com.app.model.LoanApplianceDTO;
import com.app.model.LoanEmiDTO;
import com.app.model.LoanRequest;
import com.app.model.UserLoanDetails;
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
	LoanAccountRepository loanAccountRepo;
	
	@Autowired
	UserLoanRepository userLoanRepo;
	
	public LoanDetails applyForLoan(LoanApplianceDTO loanApplianceDTO) {
		LoanDetails verifyloan = verifyLoanData(loanApplianceDTO);
		LoanDetails response = loanDetailsRepo.save(verifyloan);
		return response;
	}
		
		
	public LoanDetails verifyLoanData(LoanApplianceDTO loanApplianceDTO) {
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
				calculateRateOfInterest(loanDetails,loanApplianceDTO);
				  loanDetails.setUser(user);
			});
		}		
	     return loanDetails;
	}


	public void calculateRateOfInterest(LoanDetails loanDetails, LoanApplianceDTO loanApplianceDTO) {
		double emi;
		Float loanAmt = loanApplianceDTO.getAmount();
		//Float rate = request.getRateOfInterest();
		Double rate=LoanDetailConstants.RATE_OF_INTEREST;
		Integer tenure = loanApplianceDTO.getNoofYears();
		rate = rate / (12 * 100);
		tenure = tenure * 12;
		emi = (loanAmt * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1);
		loanDetails.setEmiAmount(emi);
	}


		
	public UserLoan fetchLoan(int uid) {
		Optional<UserLoan> user = userLoanRepo.findById(uid);
		if(user.isPresent()) {
			 return user.get();
		}
		else {
			return null;
		}
	}


	public UserLoanDetails EmiDeductionDetails(LoanAccount loanAccount) {

		List<LoanEmiDTO> emiDetails = loanAccountRepo.findByLoanAccount(loanAccount);
    	float avaialbleLoanBal = loanAccount.getBalance();
		LoanEmiDTO emiUpdated = null;		
			Optional<LoanEmiDTO> loanEmilDtOptional = emiDetails.stream().max(Comparator.comparing(LoanEmiDTO::getPaiddetails));					

			if (loanEmilDtOptional.isPresent()) {
				LoanEmiDTO loanEmiDetails = loanEmilDtOptional.get();
				 avaialbleLoanBal = loanEmiDetails.getBalanceLoanAmount();
			}
			double payEmi=0.0;
			if (avaialbleLoanBal > loanAccount.getEmiAmount()) {
				payEmi = loanAccount.getEmiAmount();
			}
			
			avaialbleLoanBal = (float) (avaialbleLoanBal - (loanAccount.getEmiAmount()));	
			
   		    UserLoanDetails totalemiDetails = new UserLoanDetails();  		 
   		    totalemiDetails.setLoanAccounts(loanAccount);   		   
   		    totalemiDetails.setPaidEmiAmount(payEmi);
   		    totalemiDetails.setAvaialbleLoanAmount(avaialbleLoanBal);
   		    totalemiDetails = loanAccountRepo.saveAndFlush(totalemiDetails);
		    return totalemiDetails;
	}
	

	public List<LoanDetails> getAllLoanDeatils(User uid) {		   
		List<LoanDetails> loanDetails = loanDetailsRepo.findAll(uid);						   		    
	     	return loanDetails;
	}	
	
}
