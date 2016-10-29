<h3>request</h3>
<%
	
	String name = request.getParameter("uName");
	String email = request.getParameter("uEmail");
	out.print("welcome " + name);
	out.print("<br/>your email is  " + email);
%>

<%
	String configValue = config.getInitParameter("configName");
	String driver = application.getInitParameter("dname");
	
	out.print("<br/><br/><br/><br/>");
	out.print("<br/>config value: " + configValue);
	out.print("<br/>application param:  " + driver);
%>

<h3>session</h3>
<%
	String command = request.getRequestURI();
	session.setAttribute("URI", command);
%>
<a href="./_a_JSP_ImplicitObjects/second.jsp">second jsp page</a>

<%-- <%   
response.sendRedirect("http://www.google.com");  
%> --%>