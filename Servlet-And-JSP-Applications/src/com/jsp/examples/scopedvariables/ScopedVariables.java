package com.jsp.examples.scopedvariables;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopedVariables
 */
@WebServlet("/ScopedVariables")
public class ScopedVariables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScopedVariables() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 request.setAttribute("att1", "First Value_request");
		 
		 HttpSession ses =request.getSession(true);
		 ses.setAttribute("att2", "Second value_session");
		 
		 ServletContext app=getServletContext();
		 app.setAttribute("att3", "Third value_aplication");
		 
		 request.setAttribute("repeated", "request");
		 ses.setAttribute("repeated1", "session");
		 app.setAttribute("repeated2", "application");
		 RequestDispatcher rd=request.getRequestDispatcher("/ScopedVars.jsp");
		 rd.forward(request, response);
	}

}
