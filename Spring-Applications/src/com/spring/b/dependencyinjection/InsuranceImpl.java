package com.spring.b.dependencyinjection;

public class InsuranceImpl implements Insurance {
	private Car car;

	@Override
	public Car getCar() {
		return car;
	}

	@Override
	public void setCar(Car car) {
		this.car = car;

	}

}
