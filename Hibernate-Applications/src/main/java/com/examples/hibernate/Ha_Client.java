package com.examples.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.product.bean.Emp;

public class Ha_Client {

	public static void main(String[] args) {
		Ha_Client demo = new Ha_Client();
		demo.addEmployee("Aswin", "Team Leader", 25000);
		demo.addEmployee("Robert", "MD", 50000);
		demo.addEmployee("Arun", "Manager", 25000);
		demo.addEmployee("kumar", "Sales Man", 6000);
		demo.addEmployee("Raj", "Clerk", 20000);
		demo.addEmployee("Sathish", "Sales Man", 8000);
		demo.addEmployee("Ravi", "Sales Man", 7000);
	}

	public void addEmployee(String ename, String design, int sal) {
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
		Transaction trasaction = null;

		try {
			// Create configuration object
			cf = new Configuration().configure();
			// Create session factory object
			sessionFactory = cf.buildSessionFactory();
			// Create session object
			session = sessionFactory.openSession();
			// Create transaction object
			trasaction = session.beginTransaction();

			Emp emp = new Emp();
			emp.setEname(ename);
			emp.setDesig(design);
			emp.setSal(sal);
			// Call the session methods
			// Save the session
			session.save(emp);
			// Commit the transaction
			trasaction.commit();
			System.out.println("Records Inserted Successfully..");

		} catch (Exception e) {
			trasaction.rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			// Close the session
			session.close();
		}

	}

}
