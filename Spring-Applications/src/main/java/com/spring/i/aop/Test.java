	package com.spring.i.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/resource/config/spconfig-aop.xml");

		Operation op = (Operation) context.getBean("opBean");
		
		op.getCounter();
		
		op.setCounter();
		
		op.message();
		
	}

}
