<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World Example</title>
</head>
<body>
 
 <br/><h5>Example of jsp:useBean action tag</h5>
 <jsp:useBean id="obj" class="com.jsp.examples.bean.Calculator"/>
 
	 <%
	 int m=obj.cube(5);
	 out.print("cube of 5 is "+m);
	 %>
 
 <br/><h5>Declaration and Expression Tag</h5>
  <%="----------------------------------------"%><br/>
 <!-- import -->
	<%@page import="java.util.Calendar"%>
	<%=new java.util.Date() %>
	<br>
	<%=Calendar.getInstance().getTime() %>
	<br>

	<%out.println("  have a nice day");%>
 

<!-- getParameter -->
 <%="----------------------------------------"%><br/>
	<form action="http://localhost:8082/Jsp_Web_Application/welcome.jsp" method="post">
	User name : <input type="text" name="t1">
	Password :<input type="text" name="t2">
	<input type="Submit"  value="Click Here">
	</form>
  
 <br/><%="----------------------------------------"%><br/>
 
 <!-- Scriplet tag example --> 
 
	<%if((Math.random())<0.5){%>
	<h2> have a nice day </h2>
	<%}else{%>
	<h2>have a loosy day</h2>
	<%}%>

  
</body>
</html>