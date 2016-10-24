package com.ormapping.customer.bean;

import java.util.Date;

/**
 * 
 * HQL joins
 */

/*
CREATE sequence order_seq start WITH 100;

CREATE TABLE order_tbl (
  order_id number(5), 
  order_date date, 
  customer_id number(5), 
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);
 */
public class Order {
	private long orderId;
	private Date orderDate;
	private Customer customer;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
