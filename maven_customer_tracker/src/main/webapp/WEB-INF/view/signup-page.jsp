<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>

	<h1>Create an account</h1>

	<div>
	
		<form:form action="${pageContext.request.contextPath }/saveUser" method="POST" modelAttribute="newUser">
				<p>
					User name: <form:input path="username"/>
				</p>
				
				<p>
					Password <form:input path="password" />
				</p>
				
				<input type="submit" value="Create">
		</form:form>
	
	</div>
	
	<hr>
	
	<button onclick="window.location.href='login'">Login</button>



</body>
</html>