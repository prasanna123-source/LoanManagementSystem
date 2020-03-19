package com.app.config;

import org.springframework.batch.item.ItemProcessor;

import com.app.entity.User;

public class DBLogProcessor implements ItemProcessor<User, User>
{

	@Override
	public User process(User user) throws Exception {
		System.out.println("Inserting user : " + user);
		return user;
	} 
	
}
