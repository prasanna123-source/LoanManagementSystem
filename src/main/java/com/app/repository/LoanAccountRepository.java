package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.LoanAccount;
import com.app.model.LoanEmiDTO;
import com.app.model.UserLoanDetails;


@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccount , Integer> {

	java.util.List<LoanEmiDTO> findByLoanAccount(LoanAccount loanAccount);

	UserLoanDetails saveAndFlush(UserLoanDetails totalemiDetails);

	

}
