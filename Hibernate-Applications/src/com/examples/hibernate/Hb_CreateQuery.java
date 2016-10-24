package com.examples.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.util.HibernateUtil;
import com.product.bean.Emp;

public class Hb_CreateQuery {

	public static void main(String[] args) {

		Hb_CreateQuery createQuery = new Hb_CreateQuery();
		createQuery.ListEmployee();

	}

	public void ListEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Query qry = session.createQuery(" from Emp");
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

}
