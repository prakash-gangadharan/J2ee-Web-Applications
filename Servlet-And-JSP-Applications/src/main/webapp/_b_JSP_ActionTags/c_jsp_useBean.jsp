<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:useBean action tag</title>
</head>
<body>
	<jsp:useBean id="obj" class="com.jsp.examples.bean.Calculator" />
	<%
		int n = obj.cube(5);
		out.print("The value is: " + n);
	%>
</body>
</html>