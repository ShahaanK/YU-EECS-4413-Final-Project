<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
</head>
<body>
    <!-- Header -->
	<jsp:include page="header.jsp"/>
	
	<div class="main-content">
    <h1>Sign In</h1>
    <form action="LoginServlet" method="post">
    	<input type="hidden" name="action" value="login">
    	<input type="submit" value="Login">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        </form>
		<button class="login-button">Login</button>
	</div>
</body>
</html>
