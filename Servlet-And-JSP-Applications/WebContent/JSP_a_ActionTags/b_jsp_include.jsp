<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:include action tag without parameter</title>
</head>
<body>
	<h4>Header</h4>
		<jsp:include page="printdate.jsp" />
	<h4>footer</h4>
	
	
	
	<!-- Passing parameters dynamically with href -->
	<a href="printdate.jsp?name=hello_user&level=level1">Page 2</a>
</body>
</html>