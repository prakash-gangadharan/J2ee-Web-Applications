<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<% out.print("Today is: "+java.util.Calendar.getInstance().getTime()); %> 
	<br/><br/>Username : <%= request.getParameter("uname") %>
	
	
	<!-- Passing parameters dynamically with href -->
	<br/>Param 1 : <%= request.getParameter("name") %>
	<br/>Param 2 : <%= request.getParameter("level") %>
</body>
</html>