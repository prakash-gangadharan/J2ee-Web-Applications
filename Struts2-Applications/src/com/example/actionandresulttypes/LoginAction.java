package com.example.actionandresulttypes;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username = null;
	private String password = null;
	
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
	
	public String execute(){
		if(getUsername().equalsIgnoreCase("") || getPassword().equalsIgnoreCase("")){
			return LOGIN;
		}else if(getUsername().equalsIgnoreCase("admin") || getPassword().equalsIgnoreCase("admin")){
			return SUCCESS;
		}else return ERROR;
		
	}

}
