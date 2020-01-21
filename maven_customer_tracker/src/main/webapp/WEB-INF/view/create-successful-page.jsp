<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create-successful-page</title>
</head>
<body>

	<h1>Congratulation, your new account has been created!!!</h1>
	
	

	<p>
		<button onclick="window.location.href='${pageContext.request.contextPath}/home'" >Login</button>
	</p>

</body>
</html>