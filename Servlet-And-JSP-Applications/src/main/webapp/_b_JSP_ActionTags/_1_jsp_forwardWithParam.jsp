<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:forward action tag with parameter</title>
</head>
<body>
	<h3>jsp:forward action tag with parameter</h3>
		<jsp:forward page="printdate.jsp">
			<jsp:param name="uname" value="op=sessionOut" />
		</jsp:forward>
</body>
</html>