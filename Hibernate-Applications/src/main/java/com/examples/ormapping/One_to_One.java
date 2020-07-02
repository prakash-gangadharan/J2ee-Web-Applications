package com.examples.ormapping;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.util.HibernateUtil;
import com.ormapping.customer.bean.Address;
import com.ormapping.customer.bean.Customer;

public class One_to_One {

	public static void main(String[] args) {
		Configuration cf;
		SessionFactory sessionFactory;
		Session session = null;
		Transaction trasaction = null;

		try {
			// Create configuration object
			cf = new Configuration().configure("hibernate_or_mapping.cfg.xml");
			// Create session factory object
			sessionFactory = cf.buildSessionFactory();
			// Create session object
			session = sessionFactory.openSession();
			// Create transaction object
			trasaction = session.beginTransaction();
			
			trasaction.begin();
			
			Customer customer = new Customer();
			customer.setName("vanitha");
			
			Address address = new Address();
			
			address.setAddressLine1("1 new st");
			address.setAddressLine2("kallikuppam");
			address.setCity("Ambattur");
			address.setState("Tamilnadu");
			address.setPincode(600020);
			
			customer.setAddress(address);
			
			address.setCustomer(customer);
			
			session.save(customer);
			
			System.out.println("saved successfully...");
			
			trasaction.commit();
			
		}catch (Exception e) {
			trasaction.rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			// Close the session
			session.close();
		}

	}

}
