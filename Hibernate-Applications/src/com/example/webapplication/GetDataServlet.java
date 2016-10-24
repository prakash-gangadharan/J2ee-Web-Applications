package com.example.webapplication;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.product.bean.Emp;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			 // 1. configuring hibernate
			configuration = new Configuration().configure();
			
			// 2. create sessionfactory
			sessionFactory =  configuration.buildSessionFactory();
			
			// 3. Get Session object
			session =  sessionFactory.openSession();
			
			// 4. Using session methods
			  Query query = session.createQuery("from User");
			  
		      List<User> users = query.list();
		      
				Iterator<User> itr = users.iterator();
				while (itr.hasNext()) {
					User usr = itr.next();
					
					System.out.println(usr.getUserName()
							+ " - "+usr.getEmail()
							+ " - "+usr.getPhone()
							+ " - "+usr.getCity());
				}
				
	           System.out.println("\n\n users retrieved \n");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.flush();
			// Close the session
			session.close();
		}
	}

}
