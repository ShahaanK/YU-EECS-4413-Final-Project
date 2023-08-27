
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Account Creation</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

	<!-- Header -->
	<jsp:include page="header.jsp"/>

	<!-- Main Content -->
	<div class="main-content">
		<h1>Create an Account</h1>
		<form action="/4413-EcomSiteTemplate/LoginServlet" method="post">
			<input type="hidden" name="action" value="register">
    		<input type="submit" value="Create Account">
			<input type="text" name="firstName" placeholder="First Name">
			<input type="text" name="lastName" placeholder="Last Name"> <input
				type="text" name="address" placeholder="Address"> <input
				type="text" name="city" placeholder="City"> <input
				type="text" name="province" placeholder="Province"> <input
				type="text" name="country" placeholder="Country"> <input
				type="text" name="postalCode" placeholder="Postal Code"> <input
				type="email" name="email" placeholder="Email Address"> <input
				type="tel" name="phoneNumber" placeholder="Phone Number"> <input
				type="password" name="password" placeholder="Password"> <input
				type="password" name="confirmPassword"
				placeholder="Re-enter Password"> <input type="submit"
				value="Create Account">
		</form>
		<button class="login-button">Login</button>
	</div>
</body>
</html>