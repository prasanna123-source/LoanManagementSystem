package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.User;
import com.app.entity.UserLoan;

public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<UserLoan> findByPk(long loanId);

}
