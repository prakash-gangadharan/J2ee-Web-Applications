package com.example.webapplication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDAO {
	
	public void addUserDetails(String userName, String password, String email, String phone, String city) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			 // 1. configuring hibernate
			configuration = new Configuration().configure();
			
			// 2. create sessionfactory
			sessionFactory =  configuration.buildSessionFactory();
			
			// 3. Get Session object
			session =  sessionFactory.openSession();
			
			// 4. Starting Transaction
			transaction =  session.beginTransaction();
			
		       User user = new User();
	           user.setUserName(userName);
	           user.setPassword1(password);
	           user.setEmail(email);
	           user.setCity(city);
	           user.setPhone(phone);
	           session.save(user);
	           transaction.commit();
	           System.out.println("\n\n Details Added \n");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.flush();
			// Close the session
			session.close();
		}
	}

}
