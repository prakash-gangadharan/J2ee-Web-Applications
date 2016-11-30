package com.spring.a.first;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * spring scopes 
 *
 */
public class ClientLogic {
	
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("com/spring/resource/config/spconfig-0.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		//ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/resource/config/spconfig-0.xml");
		
		WelcomeBean wb = (WelcomeBean) factory.getBean("wBean");
		System.out.println(wb);
		
		System.out.println(wb.getMessage());
		
		WelcomeBean wb1 = (WelcomeBean) factory.getBean("wBean");
		System.out.println(wb1);
		
		System.out.println(wb.getMessage());
		
	}

}