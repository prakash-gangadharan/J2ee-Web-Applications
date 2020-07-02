<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP scripting elements</title>
</head>
<body>
	JSP scripting elements
	<br />
	<ul>
		<li>scriptlet</li>
		<li>expression</li>
		<li>declaration</li>
	</ul>
	<hr/>
	<p style="color: white">
--------------------------------------------------------------------------------------</p>
	
	<h4>scriptlet tag</h4>
	
	<% out.print("welcome to jsp"); %>
	
	<form action="aa_JSPScriptingElements.jsp">
		<input type="text" name="uName">
		<input type="submit" value="go"><br/>  
	</form>
	<br/><hr/>
<p style="color: white">
--------------------------------------------------------------------------------------</p>


	<h4>expression tag</h4>
	<%= "welcome to expression tag" %>
	<br>Current time :<%= java.util.Calendar.getInstance().getTime() %>
	
	
	<form action="aa_JSPScriptingElements.jsp">
		<input type="text" name="uName1"><br/>
		<input type="submit" value="go">  
	</form>
	<br/><hr/>
<p style="color: white">
--------------------------------------------------------------------------------------</p>

<h4>declaration tag that declares field and method</h4>
	<%!int data = 50;%>
	<%!
	int cube(int n) {
		return n * n * n;
		}
	%>

<%= "the value is: "+data %>
<br/>
<%= "The cube of 2 is: "+cube(3)%>

<p style="color: white">
--------------------------------------------------------------------------------------</p>


</body>
</html>