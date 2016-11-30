package com.spring.b.dependencyinjection;

public class Car {
	private String color, make, model;
	private int year;
	
	public Car() {
		System.out.println("default constructor invoked");
	}
	
	public Car(String color, String make, String model, int year) {
		System.out.println("param constructor invoked");
		this.color = color;
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public String getColor() {
		System.out.println("Sting getColor()");
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return color + " - " + make + " - " + model + " - " + year;
	}

}
