package com.curso.spring;

public class User {
	private String username;
	private String password;
	private String charge;
	private String yearOfExperience;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", charge=" + charge + ", yearOfExperience="
				+ yearOfExperience + "]";
	}
	
	

}
