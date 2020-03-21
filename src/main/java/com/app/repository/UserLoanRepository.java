package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.UserLoan;

@Repository
public interface UserLoanRepository extends JpaRepository<UserLoan,Integer>{

}
