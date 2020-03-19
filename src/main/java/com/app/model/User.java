package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int userId;
	private String userName;
	private String gender;
	private int age;
	private String pan;
	private String adhar;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	
	public User(int userId, String userName, String gender, int age, String pan, String adhar) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.pan = pan;
		this.adhar = adhar;
	}
	public User() {		
	}

}
