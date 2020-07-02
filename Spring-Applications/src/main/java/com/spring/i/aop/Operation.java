package com.spring.i.aop;

public class Operation {
	
	public void message(){
		System.out.println("message method is invoked");
	}
	
	public int getCounter(){
		System.out.println("getCounter method is invoked");
		return 2;
	}
	
	public int setCounter(){
		System.out.println("setCounter method is invoked");
		return 3;
	}

}
