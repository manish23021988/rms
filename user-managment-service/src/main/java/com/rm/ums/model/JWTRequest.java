package com.rm.ums.model;

import java.io.Serializable;

public class JWTRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	private String accesskey;
	
	//need default constructor for JSON Parsing
	public JWTRequest()
	{
		
	}
	
	public JWTRequest(String key) {
		super();
		this.accesskey = key;
	}

	public JWTRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccesskey() {
		return accesskey;
	}

	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}
	
}