<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Account Creation</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

    <!-- Header -->
    <jsp:include page="header.jsp"/>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Create an Account</h1>

        <p class="success-message">Registration Successful!</p>
        <p>Your account type: ${accountType}</p>
        <p>Registered email: ${registeredEmail}</p>
		<p>Kindly ensure you remember your password, as our website does not offer a "retrieve password" feature.</p>
        <p><a href="${pageContext.request.contextPath}/index.jsp">Return to the homepage</a></p>
    </div>
</body>
</html>
