package com.capg.onlineSweetMart.security;

import org.springframework.stereotype.Component;

public class JwtResponse {
	String token;
	public JwtResponse(String token) {
		this.token =token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}
	
	
}
