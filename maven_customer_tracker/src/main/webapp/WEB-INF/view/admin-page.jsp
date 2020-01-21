<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee account management</title>
</head>
<body>

	<h1>Employees' account management system</h1>

	<table>
		<tr>
			<td>User name</td>
			<td>Password</td>
		</tr>
		
		<c:forEach var="user" items="${userList }">
		
		<tr>
			<td> ${user.username} </td>
			<td> ${user.password } </td>
		</tr>
		
		</c:forEach>
		
		
	</table>

	<hr>
	
	<div>
		<button onclick="window.location.href='${pageContext.request.contextPath}/home'">Home</button>
	</div>

	
<div>
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</div>

</body>
</html>