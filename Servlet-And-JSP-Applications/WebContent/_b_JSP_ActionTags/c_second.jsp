<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reusing Bean in Multiple Jsp Pages</title>
</head>
<body>
	<jsp:useBean id="obj" class="com.jsp.examples.bean.User" scope="session"></jsp:useBean>
	<jsp:getProperty property="name" name="obj" /><br/>
	<jsp:getProperty property="password" name="obj" /><br/>
	<jsp:getProperty property="email" name="obj" /><br/>
	
	<h5>Using variable value in setProperty tag</h5>
	<%String uName="Vanitha"; %> 
	<jsp:setProperty property="name" name="obj" value="<%=uName %>"/><br/>
	<jsp:getProperty property="name" name="obj"/>
</body>
</html>