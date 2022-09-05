package com.capg.onlineSweetMart.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserDto {
	
	private int userId;
	
	private String name;
	private String email;
	private String password;
	private String role;
	private String street;
	private String city;
	private String state;
	private String pincode;
	private Integer resetToken;
	
	public int getUserid() {
		return userId;
	}
	public void setUserid(int userid) {
		this.userId =  userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Integer getResetToken() {
		return resetToken;
	}
	public void setResetToken(Integer resetToken) {
		this.resetToken = resetToken;
	}
	
}
