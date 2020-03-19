package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.UserLoan;
import com.app.service.LoanApplicationService;

@RestController
@RequestMapping("/loans")
public class LoanApplicationController {
	
	@Autowired	
	LoanApplicationService loanService;
	

    @GetMapping(value = "/{loanId}")
    public ResponseEntity<?> findLoanById(@PathVariable("loanId") long loanId) {
        java.util.Optional<UserLoan> loan$ = loanService.findLoanById(loanId);

        if (loan$.isPresent()) {
            return new ResponseEntity<>(loan$.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
}
