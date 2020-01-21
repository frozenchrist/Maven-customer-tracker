<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page isELIgnored="false" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
</head>
<body>

<h1>Sorry, You are not authorized to visit this page.</h1>

<p>
<button onclick="window.location.href='${pageContext.request.contextPath}/home'">Home page</button>
</p>

<form:form action="${pageContext.request.contextPath }/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>

</body>
</html>