package com.spring.c.Dependencyintheformofobjects;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/spring/resource/config/spconfig-1.xml");
		
		Customer customer = (Customer) context.getBean("cus");
		Person pers = (Person) context.getBean("person1");

		System.out.println(customer);

		List ls = customer.getLists();

		Iterator<Person> itr = ls.iterator();

		while (itr.hasNext()) {
			Person ob = itr.next();
			System.out.print(ob.getName() + " - ");
			System.out.print(ob.getAge() + " - ");
			System.out.println(ob.getAddress());

		}

	}

}
