package com.spring.e.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = null;

		// Auto  wiring by name
		context = new ClassPathXmlApplicationContext(
				"com/spring/e/autowiring/config/spconfig-autowiring-1.xml");
		
		Customer customer1 = (Customer) context.getBean("CustomerBean1");
		System.out.println(customer1);
		
		
		/*
		 *  Auto  wirirng byType
		 *  setter injection
		 */
		context = new ClassPathXmlApplicationContext(
				"com/spring/e/autowiring/config/spconfig-autowiring-2.xml");
		
		Customer customer2 = (Customer) context.getBean("CustomerBean2");
		System.out.println(customer2);
		
		
		/*
		 * Auto  wirirng by constructor
		 * constructor injection
		 */
		
		context = new ClassPathXmlApplicationContext(
				"com/spring/e/autowiring/config/spconfig-autowiring-3.xml");
		
		Customer customer3 = (Customer) context.getBean("CustomerBean3");
		System.out.println(customer3);
		
		/*
		 * Auto wirirng by autodetect
		 * 1st will works as Spring Autowiring constructor 
		 * if not then works as Spring Autowiring byType,
		 */
		
		context = new ClassPathXmlApplicationContext(
				"com/spring/e/autowiring/config/spconfig-autowiring-4.xml");

		Customer customer4 = (Customer) context.getBean("CustomerBean4");
		System.out.println(customer4);

	}

}