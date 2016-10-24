package com.example.actionandresulttypes;

import java.util.Calendar;

import com.opensymphony.xwork2.ActionSupport;

public class GreetAction extends ActionSupport{
	private String greet = null;
	private String username = null;
	private String password = null;
	
	public String getGreet() {
		return greet;
	}
	public void setGreet(String greet) {
		this.greet = greet;
	}
	
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
		Calendar calendar = Calendar.getInstance();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println("Hours: "+hours);
		
		if(hours < 12){
			setGreet("Good Morning");
		}else if(hours < 16){
			setGreet("Good Noon");
		}else if(hours < 19){
			setGreet("Good Evening");
		}else{
			setGreet("Good Night");
		}
		return SUCCESS;
	}
}
