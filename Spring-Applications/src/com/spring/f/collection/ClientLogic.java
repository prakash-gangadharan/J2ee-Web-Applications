package com.spring.f.collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClientLogic {

	public static void main(String[] args) {
		Resource res = new ClassPathResource(
				"com/spring/resource/config/spconfig-collection-0.xml");
		BeanFactory factory = new XmlBeanFactory(res);

		SetCollection setCollection = factory.getBean("setCollection", SetCollection.class);

		setCollection.show(); // set
		setCollection.showServers(); // list
		setCollection.showModules(); // map
	}

}
