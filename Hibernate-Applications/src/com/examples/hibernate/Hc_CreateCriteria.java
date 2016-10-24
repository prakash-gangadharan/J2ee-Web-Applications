package com.examples.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.hibernate.util.HibernateUtil;
import com.product.bean.Emp;

public class Hc_CreateCriteria {

	public static void main(String[] args) {
		Hc_CreateCriteria createCriteria = new Hc_CreateCriteria();
		createCriteria.listEmployee();
	}

	public void listEmployee() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria crt = session.createCriteria(Emp.class);
			crt.setMaxResults(3);
			List lst = crt.list();
			for (Iterator itr = lst.iterator(); itr.hasNext();) {
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
