package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.LoanAccount;
import com.app.entity.LoanDetails;
import com.app.entity.User;
import com.app.entity.UserLoan;
import com.app.model.LoanApplianceDTO;
import com.app.model.LoanRequest;
import com.app.model.UserLoanDetails;
import com.app.service.LoanApplicationService;

@RestController
@RequestMapping("/loans")
public class LoanApplicationController {
	
	@Autowired	
	LoanApplicationService loanService;
	   
    
    @PostMapping
	public ResponseEntity<?> saveLoanData(@RequestBody LoanApplianceDTO loanApplianceDTO) {
		LoanDetails loanDetails = loanService.applyForLoan(loanApplianceDTO);
		return ResponseEntity.ok().body(loanDetails);
	}
	
	@GetMapping("/loanData/{userId}")
	public ResponseEntity<?> fetchLoanById(@PathVariable("userId") Integer userId){
		UserLoan response = loanService.fetchLoan(userId);
		return ResponseEntity.ok().body(response);
	}
    
	@GetMapping("/getLoanDetails")
	public ResponseEntity<?> getAllLoanDetails(@PathVariable("userId") User user) {
		return new ResponseEntity<>(loanService.getAllLoanDeatils(user), HttpStatus.OK);
	}
	
	@GetMapping("/EmiDetails")
	public ResponseEntity<?> getAllEmiDetails(LoanAccount loanAccount) {
		return new ResponseEntity<>(loanService.EmiDeductionDetails(loanAccount), HttpStatus.OK);
	}
	
}
