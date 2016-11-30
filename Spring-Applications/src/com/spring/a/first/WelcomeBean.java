package com.spring.a.first;

public class WelcomeBean {
	
	public WelcomeBean() {
		System.out.println("\nConstructor Invoked...\n");
	}
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}