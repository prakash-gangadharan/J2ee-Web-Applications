package com.example.wildcardmapping;

import com.opensymphony.xwork2.ActionSupport;

public class CreditAction extends ActionSupport{
	
	public String add(){
		System.out.println("Added credits....");
		return SUCCESS;
		
	}
	
	public String sub(){
		System.out.println("Deducted credits.....");
		return SUCCESS;
		
	}
}
