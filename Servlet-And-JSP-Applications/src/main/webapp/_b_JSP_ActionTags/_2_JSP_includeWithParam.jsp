<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:include action tag with parameter</title>
</head>
<body>
	<h4>Header</h4>
		<jsp:include page="printdate.jsp">
			<jsp:param name="uname" value="Prakash" />
		</jsp:include>
	<h4>footer</h4>
</body>
</html>