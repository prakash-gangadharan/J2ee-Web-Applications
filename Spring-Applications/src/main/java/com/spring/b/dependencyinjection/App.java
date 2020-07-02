package com.spring.b.dependencyinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
	
	public static void main(String[] args)
	{
		Resource resource = new ClassPathResource("spconfig-0.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		
		// Setter Injection
		Object obj = beanFactory.getBean("car1");
		Car obj1 = (Car)obj;
		System.out.println(obj1);
		
		System.out.println("================================");

		// Constructor Injection
		Car obj2=(Car)beanFactory.getBean("car2");
		System.out.println(obj2);
		
		System.out.println("================================");
		
		// Reference to other beans
		InsuranceImpl ins=(InsuranceImpl)beanFactory.getBean("insure");
		System.out.println(ins.getCar());
		
		
		
	}

}
