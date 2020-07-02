package com.examples.getparameters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetParameterDemo
 */
public class GetParameterDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetParameterDemo() {
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
		String strAction = request.getRequestURI();
		out.write(strAction);
		// getParameter method
		if (strAction.endsWith("GetParameterDemo/getParameter")) {
			String strUserName, strPassword;
			strUserName = request.getParameter("t1");
			strPassword = request.getParameter("t2");

			out.println("<br/><br/>User name : " + strUserName + "<br/>Password : " + strPassword);
			
			// getParameterValues method
		} else if(strAction.endsWith("GetParameterDemo/getParameterValues")){
			String strUserName, strPassword;
			strUserName = request.getParameter("t1");
			strPassword = request.getParameter("t2");
			
			String loc[] = request.getParameterValues("t3");

			out.println("<br/><br/>User name : " + strUserName + "<br/>Password : " + strPassword);
			
			for (int i = 0; i < loc.length; i++) {
				out.write("<li>" + loc[i] + "</li>");
			}
			
			// getParameterNames method
		}else if(strAction.endsWith("GetParameterDemo/getParameterNames")){
			Enumeration<String> eNum = request.getParameterNames();
			
			while(eNum.hasMoreElements()){
				String paramName = (String)eNum.nextElement();
				String Value = request.getParameter(paramName);
				
				out.write("<li>" + Value + "</li>");
			}
		}
		
	}

}
