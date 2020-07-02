<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP scripting elements</title>
</head>
<body>

	<h4>Example of JSP scriptlet tag that prints the user name</h4>
	<%
		String name = request.getParameter("uName");
		out.println("Welcome: " + name);
	%>
	
	
	<h4>Example of JSP expression tag that prints the user name</h4>
	<%="welcome : " + request.getParameter("uName1")%>

</body>
</html>