package com.rest.examples.bean;


public class Order {
	//@JsonProperty
	private String customer;
	private String address;
	
	//@JsonProperty("bill-amount")
	private String amount;

	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}


}
