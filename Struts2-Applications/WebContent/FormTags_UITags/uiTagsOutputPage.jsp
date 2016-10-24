<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ui Tags Output Page</title>
</head>
<body>
	<h4>ui Tags Output Page</h4><br/>
	Name : <s:property value="name" /><br/>
	Address: <s:property value="address" /><br/>
	Password: <s:property value="password" /><br/>
	Gender: <s:property value="gender" /><br/>
	Course name: <s:property value="courseName" /><br/>
	Search Engine: <s:property value="yourSearchEngine" /><br/>
	Selected Course: <s:property value="courseName" /><br/>
	
</body>
</html>