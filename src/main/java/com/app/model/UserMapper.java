package com.app.model;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class UserMapper implements FieldSetMapper<User> {

	@Override
	public User mapFieldSet(FieldSet fieldData) throws BindException {
		User user=new User();
		user.setUserId(fieldData.readInt("userId"));
		user.setUserName(fieldData.readString(1));
		user.setAge(fieldData.readInt(2));
		user.setGender(fieldData.readString(3));
		user.setPan(fieldData.readString(4));
		user.setAdhar(fieldData.readString(5));
		return user;
	}

}
