package com.ormapping.customer.bean;

/**
 *  HQL Join
 */

/*
CREATE sequence addr_seq start WITH 10;

CREATE TABLE address (
  address_id number(5) primary key,
  address_line1 varchar2(25) not null,
  address_line2 varchar2(20),
  city varchar2(15) not null,
  state varchar2(15) not null,
  pincode number(6) not null
);
*/

public class Address {
	
	private long addressId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private Integer pincode;
	private Customer customer; 
	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
