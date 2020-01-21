<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@page isELIgnored="false" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding a new customer</title>
</head>
<body>

<h1><a href="${pageContext.request.contextPath }/home">Customer Management System</a></h1>

<div>
	<form:form action="${pageContext.request.contextPath }/home/saveCustomer" method="POST" modelAttribute="newCustomer" >
	
		
	
		<p>
			<form:hidden path="id"/>
			
			First name: <form:input path="firstName"/>
		</p>
		
		<p>
			Last name: <form:input path="lastName"/>
		</p>
		
		<p>
			Email: <form:input path="email"/>
		</p>
		
		<input type="submit" value="Save">
	
	</form:form>
</div>


</body>
</html>