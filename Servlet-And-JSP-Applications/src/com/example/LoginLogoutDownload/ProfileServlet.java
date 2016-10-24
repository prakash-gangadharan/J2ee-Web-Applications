package com.example.LoginLogoutDownload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginBean lBean=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("LoginLogoutDownload/link.html").include(request, response);  
        
        HttpSession session = request.getSession(false);
        
		if (session != null) {
			String name = (String) session.getAttribute("name");

			out.print("Hello, " + name + " Welcome to Profile");
			
			lBean=(LoginBean)session.getAttribute("setBean");
			
			out.println("usr_ID: "+lBean.getnUserId());
			out.println("\n - "+lBean.getStrEmailId());
			out.println("\n - "+lBean.getStrFirstName());
			out.println("\n - "+lBean.getStrLastName());
			out.println("\n - "+lBean.getStrPassword());
			
			
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("LoginLogoutDownload/login.html").include(request, response);
		}
		out.close();
	}

}
