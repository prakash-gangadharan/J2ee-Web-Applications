package com.spring.g.readfrompropetyfile;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadFromPropFileDemo {
	public static void main(String args[]) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("com/spring/resource/config/spconfig-2.xml");
		UserBean bean = (UserBean) beanFactory.getBean("userBean");
		System.out.println(bean.getMyName());
		System.out.println(bean.getPassword());
	}
}
