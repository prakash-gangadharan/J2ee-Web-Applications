package com.example.HttpSessionListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionCollector implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session created");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
		System.out.println("session Destroyed");
		
	}

}
