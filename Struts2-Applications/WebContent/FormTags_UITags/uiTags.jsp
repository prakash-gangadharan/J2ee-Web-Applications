<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>UI tags</title>
</head>
<body>
	<s:form action="Information.action" method="POST">
		<s:label name="formName" value="Student Registration Form"></s:label>
		<s:textfield name="name" label="Name"></s:textfield>
		<s:textarea name="address" label="Address"></s:textarea>
		<s:password name="password" label="Password"></s:password>
		<s:radio list="{'Male','Female'}" name="gender" label="Gender"></s:radio>

		<!-- select drop down box example -->

	<s:select label="Course Name"
		headerKey="0" headerValue="Select Course"
		list="courseType"
		name="courseName" />

	<s:select label="What's your favor search engine"
		headerKey="-1" headerValue="Select Search Engines"
		list="searchEngine"
		name="yourSearchEngine" />

		<!-- CheckBoxList Tag -->
	
	<s:checkboxlist list="locations" name="locationName" label="Check your Locations" value="DefaultLocation"/>
		<!-- Here DefaultCourse is the method in the bean class -->

		<s:hidden name="message" value="Hello Struts"></s:hidden>
		<s:reset></s:reset>
		<s:submit></s:submit>
	</s:form>
</body>
</html>