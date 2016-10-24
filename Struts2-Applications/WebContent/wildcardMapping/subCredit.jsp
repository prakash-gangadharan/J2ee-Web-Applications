<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>subCredit</title>
</head>
<body>
	<s:form action="Credit_sub" method="POST">
		<s:textfield name="sub" label="Sub"/>
		<s:submit value="sub" align="center"></s:submit>
	</s:form>
</body>
</html>