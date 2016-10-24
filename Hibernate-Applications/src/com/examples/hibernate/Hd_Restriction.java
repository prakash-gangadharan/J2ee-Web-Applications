package com.examples.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hibernate.util.HibernateUtil;
import com.product.bean.Emp;

public class Hd_Restriction {

	public static void main(String[] args) {
		Hd_Restriction restriction = new Hd_Restriction();
		restriction.listEmployee();
	}

	public void listEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria crt = session.createCriteria(Emp.class);
			crt.add(Restrictions.eq("desig", "Sales Man"));
			crt.addOrder(Order.desc("sal"));

			List lst = crt.list();
			Iterator itr = lst.iterator();
			while (itr.hasNext()) {
				Emp emp = (Emp) itr.next();
				System.out.println(emp.getEmpno() + " - " + emp.getEname() + " - " + emp.getSal());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

}
