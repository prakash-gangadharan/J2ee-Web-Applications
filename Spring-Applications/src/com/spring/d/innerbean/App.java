package com.spring.d.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = null;

		context = new ClassPathXmlApplicationContext(
				"com/spring/resource/config/spconfig-innerbean.xml");

		// Using ref tag
		Customer customer1 = (Customer) context.getBean("CustomerBean1");
		System.out.println(customer1);
		
		// Using setter injection
		Customer customer2 = (Customer) context.getBean("CustomerBean2");
		System.out.println(customer2);
		
		// Using constructor injection
		Customer customer3 = (Customer) context.getBean("CustomerBean3");
		System.out.println(customer3);

	}

}