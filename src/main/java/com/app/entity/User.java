package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)	
	@Column(name = "user_id")
	private int userId;	
	
	@Column(name = "user_name")
	private String userName;	
	private String gender;
	private int age;
	private int salary;
	private String pan;
	private String adhar;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "loanId")    
	private List<UserLoan> userloans;
	
	public List<UserLoan> getUserloans() {
		return userloans;
	}
	public void setUserloans(List<UserLoan> userloans) {
		this.userloans = userloans;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
	public User(int userId, String userName, String gender, int age, int salary, String pan, String adhar,
			List<UserLoan> userloans) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.pan = pan;
		this.adhar = adhar;
		this.userloans = userloans;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", age=" + age + ", salary="
				+ salary + ", pan=" + pan + ", adhar=" + adhar + ", userloans=" + userloans + "]";
	}
	public User() {
		super();		
	}	
	
}
