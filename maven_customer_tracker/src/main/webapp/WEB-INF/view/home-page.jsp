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
<title>Home Page</title>
</head>
<body>
	<h1><a href="${pageContext.request.contextPath }/home">Customer Management System</a></h1>
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br>
		<br>
		Role: <security:authentication property="principal.authorities"/>
	</p>
	
	<div>

	<div>
		<button onclick="window.location.href='${pageContext.request.contextPath}/home/addForm'">Add a new customer</button>
	</div>
		
	<br>
	
		<div>
			<form:form action="${pageContext.request.contextPath }/home/search" method="GET" >
				Search customer: <input type="text" name="searchName">
				<input type="submit" value="Search">
			</form:form>	
		</div>
	
		
	

	<table>
		
		
	
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			
			<security:authorize access="hasRole('Manager')">
				<th>Actions</th>
			</security:authorize>	
			
		
		
		</tr>
		
		
		<c:forEach var="customer" items="${customerList}" >
		
			<c:url var="updateLink" value="/manager/updateCustomer">
				<c:param name="customerId" value="${customer.id }" ></c:param>
			</c:url>
		
			<c:url var="deleteLink" value="/manager/deleteCustomer">
				<c:param name="customerId" value="${customer.id }"></c:param>
			</c:url>
			
		
			<tr>
				<td>${customer.firstName }</td>
				<td>${customer.lastName }</td>
				<td>${customer.email }</td>
				
				<security:authorize access="hasRole('Manager')">
				
				<td>
					<a href="${updateLink }">Update</a> | <a href="${deleteLink }" onclick="if (!(confirm('Are you sure you want to delete this customer?')))
						return false">Delete</a>
				</td>
				
				</security:authorize>
				
				
			</tr>
		</c:forEach>
	
	</table>
</div>
	
	<p>
	
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
		<input type="submit" value="Logout" >
	</form:form>

	</p>
	
	<hr>
	
	<security:authorize access="hasRole('Admin')">
		<p>
			<button onclick="window.location.href='${pageContext.request.contextPath}/admin/manage'">Admin Portal</button>
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('Manager')">
		<p>
			<button onclick="window.location.href='${pageContext.request.contextPath}/manager'">Manager Portal</button>
		</p>
	</security:authorize>
	

</body>
</html>