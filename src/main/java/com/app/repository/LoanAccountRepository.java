package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.LoanAccount;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccount , Integer> {

}
