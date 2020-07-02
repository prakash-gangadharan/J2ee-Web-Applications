package com.examples.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.product.bean.Emp;

public class Hf_HQL {

	public static void main(String[] args) {
		Hf_HQL hql = new Hf_HQL();
		hql.fromClause();
		// hql.selectClause();
		// hql.whereClause();
		// hql.namedParameters();
		// hql.insertClause();
		// hql.updateClause();
		// hql.deleteClause();

	}

	/**
	 *		FROM clause
	 */
	public void fromClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// String hql = "FROM Emp";
			// String hql = "FROM com.product.bean.Emp"; // fully qualified classname
			// String hql = "FROM Emp AS E";
			String hql = "FROM Emp E";
			Query qry = session.createQuery(hql);
			List lst = qry.list();
			Iterator itr = lst.iterator();
			while (itr.hasNext()) {
				Emp emp = (Emp) itr.next();
				System.out.println(emp.getEmpno() + " - " + emp.getEname() + " - " + emp.getDesig() + " - " + emp.getSal());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * 	SELECT Clause 
	 * 	HQL uses class name instead of table name and property name instead of column name.
	 */
	public void selectClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "SELECT ename, desig FROM Emp";
			Query qry = session.createQuery(hql);
			Iterator itr = qry.iterate();
			while (itr.hasNext()) {
				Object emp[] = (Object[]) itr.next();
				System.out.println(emp[0] + " - is -  " + emp[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * 	WHERE clause
	 */
	public void whereClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM Emp E WHERE desig = 'Sales Man'";
			Query qry = session.createQuery(hql);
			List lst = qry.list();
			Iterator itr = lst.iterator();
			while (itr.hasNext()) {
				Emp emp = (Emp) itr.next();
				System.out.println(emp.getEmpno() + " - " + emp.getEname() + " - " + emp.getDesig() + " - " + emp.getSal());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * 		Named parameters
	 */
	public void namedParameters() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM Emp E WHERE E.desig = :desig";
			Query qry = session.createQuery(hql);
			qry.setParameter("desig", "Sales Man");
			List lst = qry.list();
			Iterator itr = lst.iterator();
			while (itr.hasNext()) {
				Emp emp = (Emp) itr.next();
				System.out.println(emp.getEmpno() + " - " + emp.getEname() + " - " + emp.getDesig() + " - " + emp.getSal());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * 		Insert Clause
	 */
	public void insertClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "Insert into Emp (empno) values(11)";
			Query qry = session.createQuery(hql);
			int n = qry.executeUpdate();
			System.out.println(n + "	rows affected");

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * 		UPDATE Clause
	 */
	public void updateClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "UPDATE Emp SET sal = :salary where ename = :empname";
			Query qry = session.createQuery(hql);
			qry.setParameter("salary", 25000);
			qry.setParameter("empname", "Arun");

			int n = qry.executeUpdate();
			System.out.println(n + "	rows affected");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * 		DELETE Clause
	 */
	public void deleteClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {

			String hql = "DELETE FROM Emp WHERE ename=:name";
			Query qry = session.createQuery(hql);
			qry.setParameter("name", "Aswin");
			int n = qry.executeUpdate();
			System.out.println(n + "	rows affected");

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.flush();
			session.close();
		}
	}

}
