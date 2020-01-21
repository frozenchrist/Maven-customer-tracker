<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please Login</title>


</head>
<body>

<h1>Please Login</h1>

<form:form action="${pageContext.request.contextPath}/loginAuthentication " method="POST">

	<c:if test="${param.error != error }">
		<strong style="color: red;">Your user name or password is wrong !!!</strong>
	</c:if>
	
	
	
	<p>
	User name: <input type="text" name="username" >
	</p>
	
	<p>
	Password: <input type="password" name="password">
	</p>
	
	<input type="submit" name="Login">
	
</form:form>

<hr>

<button onclick="window.location.href='signup'">Register</button>


</body>
</html>