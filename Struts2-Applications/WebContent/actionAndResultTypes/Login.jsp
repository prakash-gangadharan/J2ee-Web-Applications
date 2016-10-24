<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<s:form action="doLogin" method="POST">
		<s:textfield name="username" label="Login name"/>
		<s:password name="password" label="Password"/>
		<s:submit value="Login" align="center"/>
	</s:form>
</body>
</html>