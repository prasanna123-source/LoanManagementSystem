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

import com.app.entity.LoanDetails;
import com.app.entity.User;
import com.app.entity.UserLoan;
import com.app.model.LoanApplianceDTO;
import com.app.model.LoanRequest;
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
	
//	@GetMapping
//	public ResponseEntity<?> fetchLoanDetails(){
//		List<User> response = loanService.fetLoans();
//		return ResponseEntity.ok().body(response);
//	}
//	
//	@GetMapping("/loanData/{userId}")
//	public ResponseEntity<?> fetchLoan(@PathVariable("userId") Integer userId){
//		Optional<User> response = loanService.fetchLoan(userId);
//		return ResponseEntity.ok().body(response);
//	}
//	
//	@GetMapping(value = "/{loanId}")
//    public ResponseEntity<?> findLoanById(@PathVariable("loanId") long loanId) {
//        java.util.Optional<UserLoan> loan$ = loanService.findLoanById(loanId);
//
//        if (loan$.isPresent()) {
//            return new ResponseEntity<>(loan$.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
	
}
