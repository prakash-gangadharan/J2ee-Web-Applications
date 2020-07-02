package com.examples.forwardIncludeAndSendredirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardAndInclude
 */
public class ForwardAndInclude extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForwardAndInclude() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String a, b;
		PrintWriter out = response.getWriter();

		a = request.getParameter("t1");
		b = request.getParameter("t2");
		
		ServletContext ctx = request.getServletContext();
		ctx.setAttribute("msg", "Granted/Succesful");
		
		if (a.equals("java") && b.equals("admin")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/ForwardServlet");
			rd.forward(request, response);
		} else if(a.equals("wrong") && b.equals("admin")) {
			
			// Redirect response to another resource, it may be servlet, jsp or html file.
			response.sendRedirect("reLogin.html");
		}else{
			
			out.write("Sorry Wrong Password , Try Again");
			request.getRequestDispatcher("/login.html").include(request, response);
		}

	}

}
