package com.examples.namedQuery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.product.bean.Emp;

public class NamedQueryDemo {

	public static void main(String[] args) {
		NamedQueryDemo demo = new NamedQueryDemo();
		demo.listCutomer();
		
	}

	public void listCutomer() {

		Configuration cf;
		SessionFactory sessionFactory;
		Session session = null;

		try {
			// Create configuration object
			cf = new Configuration().configure();
			// Create session factory object
			sessionFactory = cf.buildSessionFactory();
			// Create session object
			session = sessionFactory.openSession();
			// Create transaction object

			// Named Query for HQL
			System.out.println("\n"+"## Named Query for HQL ##");
			Query qry = session.getNamedQuery("TeamLeader");
			List lst = qry.list();
			Iterator itr = lst.iterator();
			
			while(itr.hasNext()){
				Emp emp = (Emp)itr.next();
				System.out.println(emp.getEname()+" - "+emp.getDesig()+" - "+emp.getSal());
			}
			
			
			// Named Query for HQL and passing parameter
			System.out.println("\n"+"## Named Query for HQL and passing parameter ##");
			qry = session.getNamedQuery("Desig");
			qry.setParameter("desig", "Manager");

			lst = qry.list();
			itr = lst.iterator();
			
			while(itr.hasNext()){
				Emp emp = (Emp)itr.next();
				System.out.println(emp.getEname()+" - "+emp.getDesig()+" - "+emp.getSal());
			}
			
			
			// Named Query for HQL and parameter with CDATA
			System.out.println("\n"+"## Named Query for HQL and parameter with CDATA ##");
			qry = session.getNamedQuery("Sal");
			qry.setParameter("salary", 20000);

			lst = qry.list();
			itr = lst.iterator();
			
			while(itr.hasNext()){
				Emp emp = (Emp)itr.next();
				System.out.println(emp.getEname()+" - "+emp.getDesig()+" - "+emp.getSal());
			}
			
			
			// Named Query for NativeSQL
			System.out.println("\n"+"## Named Query for NativeSQL ##");
			qry = session.getNamedQuery("EmpQry");

			lst = qry.list();
			itr = lst.iterator();
			
			while(itr.hasNext()){
				Object[] emp = (Object[])itr.next();
				System.out.println(emp[0]+" - "+emp[1]+" - "+emp[2]);
			}
			
			// Named query for Procedure Call
			Transaction transaction = session.beginTransaction();
			qry = session.getNamedQuery("ChangeSal");
			qry.setInteger(0, 30);
			qry.setInteger(1, 9000);
			qry.executeUpdate();
			transaction.commit();
			
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
