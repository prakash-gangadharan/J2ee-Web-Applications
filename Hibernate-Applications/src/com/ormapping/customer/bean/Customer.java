package com.ormapping.customer.bean;

import java.util.Set;

/**
 * 
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
	private Address address;
	private Set<Order> orders;
	
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
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
