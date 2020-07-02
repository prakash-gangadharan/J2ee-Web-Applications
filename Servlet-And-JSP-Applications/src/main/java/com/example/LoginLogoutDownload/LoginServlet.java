package com.example.LoginLogoutDownload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("LoginLogoutDownload/link.html").include(request, response); 
		
		ServletContext context= request.getServletContext();
		String path = context.getRealPath("/");
		String ServletPath = request.getServletPath();
		String RequestURI = request.getRequestURI();
		StringBuffer RequestURL = request.getRequestURL();
		
		System.out.println("path :"+path);
		System.out.println("ServletPath: "+ServletPath);
		System.out.println("RequestURI: "+RequestURI);
		System.out.println("RequestURL: "+RequestURL);
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");  
	          
	        if(password.equals("admin")){
	        out.print("Welcome, "+name);  
	        HttpSession session=request.getSession();  
	        session.setAttribute("name", name);  
	        
			LoginBean lbean=new LoginBean();
			
			lbean.setnUserId(123);
			lbean.setStrEmailId("strEmailId");
			lbean.setStrFirstName(name);
			lbean.setStrLastName("strLastName");
			lbean.setStrPassword("strPassword");
			
			session.setAttribute("setBean", lbean);
	        }  
	        else{  
	            out.print("Sorry, username or password error!");  
	            request.getRequestDispatcher("LoginLogoutDownload/login.html").include(request, response);  
	        }  
	        out.close();  
	    }

}
