<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>addCredit</title>
</head>
<body>
	<s:form action="Credit_add" method="POST">
		<s:textfield name="add" label="Add"/>
		<s:submit value="Add" align="center"></s:submit>
	</s:form>
</body>
</html>