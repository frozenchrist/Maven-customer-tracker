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
<title>Welcome Page</title>


</head>
<body>

<h1>Welcome to Customer Management System</h1>

<c:if test="${param.logout != null }">
		<strong style="color: green;">Successfully logged out.</strong>
	</c:if>

<p>
	Already an employee?
	<button onclick="window.location.href='${pageContext.request.contextPath}/login'">Login</button>
</p>

<p>
	Need a new account?
	<button onclick="window.location.href='${pageContext.request.contextPath}/signup'">Register</button>
</p>

</body>
</html>