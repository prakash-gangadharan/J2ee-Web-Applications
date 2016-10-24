package com.example.action;

import com.opensymphony.xwork2.ActionSupport;


public class HelloWorldAction extends ActionSupport{
	private String name;
	private String greet;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGreet() {
		return greet;
	}
	public void setGreet(String greet) {
		this.greet = greet;
	}
	
	public String execute(){
		if (this.name.equals("prakash")) {
			return "success";
		} else if (this.name.equals("fail")) {
			return "failure";
		} else
			return "error";
		
	}

}
