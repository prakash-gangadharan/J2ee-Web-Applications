package com.examples.nativesql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class NativeSQLDemo {

	public static void main(String[] args) {
		NativeSQLDemo demo = new NativeSQLDemo();
		
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
			
			// Select 
			String sql = "SELECT ename, designation, sal FROM employee";
			SQLQuery qry = session.createSQLQuery(sql);
			List lst = qry.list();
			Iterator itr = lst.iterator();
			
			while(itr.hasNext()){
				Object[] obj = (Object[])itr.next();
				System.out.print(obj[0]+" - ");
				System.out.print(obj[1]+" - ");
				System.out.println(obj[2]);
			}
			
			// Scalar Query
			System.out.println("\n//Scalar Query");
			sql = "SELECT empno, ename, sal FROM employee";
			qry = session.createSQLQuery(sql)
							.addScalar("empno", IntegerType.INSTANCE)
							.addScalar("ename", StringType.INSTANCE)
							.addScalar("sal", DoubleType.INSTANCE);
			lst = qry.list();
			itr = lst.iterator();
			
			while(itr.hasNext()){
				Object[] obj = (Object[]) itr.next();
				System.out.println(obj[0]+" - "+obj[1]+" - "+obj[2]);
			}
			
			// Entity Query.
			System.out.println("//Entity Query.");
			sql = "SELECT * FROM Employee";
			qry = session.createSQLQuery(sql);
			lst = qry.list();
			itr = lst.iterator();
			
			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				System.out.println(obj[0]+" - "+obj[1]+" - "+obj[2]);
			}
			
			/*
					CREATE OR REPLACE PROCEDURE remove_emp AS 
					BEGIN
						DBMS_OUTPUT.PUT_LINE('going to delete ');
						DELETE FROM employee WHERE ename = 'testname';
					END;
					/
			 */
			
			// Call Procedure
			Transaction transaction = session.beginTransaction();
			qry = session.createSQLQuery("{call remove_emp()}");
			qry.executeUpdate();
			transaction.commit();
			
/*
		 CREATE OR REPLACE PROCEDURE salary_inc (p_id number, p_newSal number)
			IS
			BEGIN
				DBMS_OUTPUT.PUT_LINE('employee id is '||p_id);
				UPDATE employee SET SAL = p_newSal WHERE EMPNO = p_id;
			END salary_inc;
			/
 */
			// Call Procedure with parameter
			transaction = session.beginTransaction();
			qry = session.createSQLQuery("{call salary_inc(?, ?)}");
			qry.setInteger(0, 30);
			qry.setInteger(1, 8000);
			qry.executeUpdate();
			transaction.commit();
			
			// Call Procedure with named parameter
			transaction = session.beginTransaction();
			qry = session.createSQLQuery("{call salary_inc(:empno, :salary)}");
			qry.setParameter("empno", 29);
			qry.setParameter("salary", 10000);
			
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