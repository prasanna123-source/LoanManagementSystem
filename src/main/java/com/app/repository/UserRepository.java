package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.User;
import com.app.entity.UserLoan;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {	

}
