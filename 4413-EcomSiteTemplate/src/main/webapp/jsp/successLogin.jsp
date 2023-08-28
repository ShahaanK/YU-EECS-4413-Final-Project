<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Admin, model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/index.css">
<head>
    <title>Login Successful</title>

    <script>
        // Redirect to main page after 5 seconds
        setTimeout(function() {
            window.location.href = "${pageContext.request.contextPath}/index.jsp";
        }, 5000); 
    </script>
</head>
<body>

    <!-- Header -->
    <jsp:include page="header.jsp"/>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Login Successful</h1>
        <c:choose>
            <c:when test="${user.getClass().getSimpleName() eq 'Admin'}">
                <p>Welcome, Admin <strong><c:out value="${user.getFirstName()}" /></strong>!</p>
            </c:when>
            <c:when test="${user.getClass().getSimpleName() eq 'Customer'}">
                <p>Welcome, Customer <strong><c:out value="${user.getFirstName()}" /></strong>!</p>
                <p>Your email: <c:out value="${user.getEmail()}" /></p>
            </c:when>
            <c:otherwise>
                <!-- Handle other cases if needed -->
            </c:otherwise>
        </c:choose>
        <p>Current date and time: <%= new java.util.Date() %></p>
        <!-- Auto redirection text -->
        <p>Automatically redirecting to the home page in 5 seconds...</p>
        
        <!-- Manual link to go back -->
        <p>If not redirected, you can <a href="${pageContext.request.contextPath}/index.jsp">click here</a> to return to the homepage.</p>
    </div>
    </div>
</body>
</html>
