package com.spring.a.first;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClientLogic {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("com/spring/resource/config/spconfig-0.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);

		WelcomeBean wb = (WelcomeBean) beanFactory.getBean("wBean");
		wb.show();

	}

}
