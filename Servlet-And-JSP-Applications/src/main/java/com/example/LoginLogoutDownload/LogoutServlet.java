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
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		 
/*		 HttpSession session=request.getSession();  
         session.invalidate();*/
		 //logoutSession(request.getSession());
		 logoutSession(request.getSession(false));
         
         out.print("You are successfully logged out!");  
         
         out.close();  
		  
	}
	
	public static void logoutSession(HttpSession session){

		try{
			//Invalidate the session from server
			if( session != null ){
				// on session invalidate sessionDestroyed in HttpSessionCollector will be called.
				session.invalidate();
				session = null;
			}
		}catch(Exception e){
			System.out.println("Exception while Logout: "+e.getMessage());
		}

	}
	
}
