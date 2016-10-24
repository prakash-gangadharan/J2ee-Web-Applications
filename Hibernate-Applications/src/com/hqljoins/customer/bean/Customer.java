package com.hqljoins.customer.bean;

/**
 * HQL joins
 */

/*
CREATE sequence cust_seq start WITH 1000;

CREATE TABLE customer(
  customer_id number(11),
  name varchar2(50),
  address_id number(11),
  primary key(customer_id),
  foreign key(address_id) references address(address_id)
);

 */
public class Customer {
	private Long customerId;
	private String name;
	private Long addressId;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
}
