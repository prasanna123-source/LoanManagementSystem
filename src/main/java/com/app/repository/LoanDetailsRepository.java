package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.LoanDetails;
import com.app.entity.User;

@Repository
public interface LoanDetailsRepository extends JpaRepository<LoanDetails,Integer>{

	List<LoanDetails> findByLoanAccount(int uid);

	List<LoanDetails> findAll(User uid);

}
