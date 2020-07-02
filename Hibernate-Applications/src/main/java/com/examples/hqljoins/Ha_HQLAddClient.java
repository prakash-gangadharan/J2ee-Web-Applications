package com.examples.hqljoins;

import java.util.Date;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hqljoins.customer.bean.Address;
import com.hqljoins.customer.bean.Customer;
import com.hqljoins.customer.bean.Order;


public class Ha_HQLAddClient {

	public static void main(String[] args) {
		Ha_HQLAddClient demo = new Ha_HQLAddClient();
		
		demo.listCutomer();
		
	}

	public void listCutomer() {
		// 1. Create configuration object
		// 2. Create session factory object
		// 3. Create session object
		// 4. Create transaction object
		// 5. Call the session methods
		// 6. Save the session
		// 7. Commit the transaction
		// 8. Close the session

		Configuration cf;
		SessionFactory sessionFactory;
		Session session = null;

		try {
			// Create configuration object
			cf = new Configuration().configure("hibernate_hqljoins.cfg.xml");
			// Create session factory object
			sessionFactory = cf.buildSessionFactory();
			// Create session object
			session = sessionFactory.openSession();
			// Create transaction object
			
			Query qry = session.createQuery(" from Customer c, Address a where c.addressId = a.addressId");

			System.out.println(qry);
			Address address;
			Customer customer;

			// Returns One Row
			System.out.println("Address Details..");
			Iterator itr = qry.iterate();
			while(itr.hasNext()){
				Object obj[] = (Object[])itr.next();
				//System.out.println(obj.length);
				customer = (Customer)obj[0]; 
				address = (Address)obj[1];
				System.out.println("CustomerId :"+ customer.getName());
				
				System.out.println(" addressId :"+ address.getCity());
				
			}

			// Call the session methods
			// Save the session
			// Commit the transaction
			System.out.println("Records Inserted Successfully..");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			// Close the session
			session.close();
		}

	}
	
	

}