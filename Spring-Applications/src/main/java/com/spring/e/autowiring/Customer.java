package com.spring.e.autowiring;

public class Customer {
	private int id;

	private Person person;

	public Customer() {
		// default constructor
	}

	public Customer(Person person) {
		System.out.println("param constructor invoked");
		this.person = person;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		System.out.println("setPerson setter method invoked");
		this.person = person;
	}

	public String toString() {
		return "Customer : "+id+" [person=" + person + "]";
	}
}
