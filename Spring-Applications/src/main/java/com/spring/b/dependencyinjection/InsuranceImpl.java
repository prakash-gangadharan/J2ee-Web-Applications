package com.spring.b.dependencyinjection;

public class InsuranceImpl implements Insurance {
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;

	}

}
