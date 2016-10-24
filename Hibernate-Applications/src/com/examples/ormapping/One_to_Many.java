package com.examples.ormapping;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.util.HibernateUtil;
import com.ormapping.customer.bean.Address;
import com.ormapping.customer.bean.Customer;
import com.ormapping.customer.bean.Order;
import com.product.bean.Emp;

public class One_to_Many {

	public static void main(String[] args) {
		
		Configuration cf;
		SessionFactory sessionFactory;
		Session session = null;
		Transaction trasaction = null;
		Query qry =null;

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
			
			qry = session.createQuery("from Customer c where c.customerId = :cus").setLong("cus", 1007);
/*			List lst = qry.list();
			Iterator itr = lst.iterator();
			while (itr.hasNext()) {
				Customer customer = (Customer) itr.next();
				System.out.println("name :"+customer.getName());
				System.out.println("addr :"+customer.getAddress().getAddressId());
				System.out.println("addr :"+customer.getAddress().getAddressLine1());
				System.out.println("addr :"+customer.getAddress().getAddressLine2());
				System.out.println("addr :"+customer.getAddress().getCity());
				System.out.println("addr :"+customer.getAddress().getState());
				System.out.println("addr :"+customer.getAddress().getPincode());
				System.out.println("cusId:"+customer.getCustomerId());
				System.out.println("ordr :"+customer.getOrders());
			}*/

			
			Customer customer = (Customer) qry.uniqueResult();
			
			Order order1 = new Order();
			order1.setOrderDate(new Date());
			order1.setCustomer(customer);
			
			session.save(order1);
			
			
			Order order2 = new Order();
			order2.setOrderDate(new Date());
			order2.setCustomer(customer);
			
			session.save(order2);
			
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
