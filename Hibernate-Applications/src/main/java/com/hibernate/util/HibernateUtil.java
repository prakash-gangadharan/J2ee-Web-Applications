package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration cf = new Configuration().configure();
			sessionFactory = cf.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static SessionFactory getSessionFactory() {
		try {
			Configuration cf = new Configuration().configure();
			sessionFactory = cf.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;

	}
}