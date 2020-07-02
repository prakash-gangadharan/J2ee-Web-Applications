package com.hibernate.first;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Client {

	public static void main(String[] args) {
		
		Configuration cf = new Configuration().configure("hibernate_postgresql.cfg.xml");
		SessionFactory sf = cf.buildSessionFactory();
		
		System.out.println(sf);
		
		Session session = sf.openSession();
		
		
		
	}

}
