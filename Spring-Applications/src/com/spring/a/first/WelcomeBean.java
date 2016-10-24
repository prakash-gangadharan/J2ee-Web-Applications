package com.spring.a.first;

public class WelcomeBean {

	private String message;

	public void setMessage(String message) {
		System.out.println("set msg invoked");
		this.message = message;
	}

	public void show() {
		System.out.println(message);
	}

}
