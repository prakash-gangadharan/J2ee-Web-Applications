package com.examples.genericservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class GenericServletDemo
 */
public class GenericServletDemo extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public GenericServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// ServletContext objects
		ServletContext context = getServletConfig().getServletContext();
		String ContextParam = context.getInitParameter("dname");
		
		ServletContext context1 = getServletContext();
		String ContextParam1 = context1.getInitParameter("dname");
		
		System.out.println("ContextParam: "+ ContextParam);
		
		System.out.println("ContextParam1: "+ ContextParam1);
		
		out.write("Hi Beginer welcome to servlet</br>");
		out.write("<a href='./GenericServletLink'>Click here");
		out.write("</a>");
	}

}
