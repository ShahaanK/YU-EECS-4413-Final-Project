<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Admin, model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Successful</title>

    <!-- JavaScript to redirect after 5 seconds -->
    <script>
        setTimeout(function() {
            window.location.href = "${pageContext.request.contextPath}/index.jsp";
        }, 5000); // 5000 milliseconds = 5 seconds
    </script>
</head>
<body>
    <!-- Header -->
    <jsp:include page="header.jsp"/>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Login Successful</h1>
        <% if ("customer".equals(request.getAttribute("loggedInUser"))) { %>
            <p>Welcome, Customer <strong><%= ((Customer) session.getAttribute("user")).getFirstName() %></strong>!</p>
            <p>Your email: <%= ((Customer) session.getAttribute("user")).getEmail() %></p>
        <% } else if ("admin".equals(request.getAttribute("loggedInUser"))) { %>
            <p>Welcome, Admin <strong><%= ((Admin) session.getAttribute("user")).getFirstName() %></strong>!</p>
        <% } %>
        <p>Current date and time: <%= new java.util.Date() %></p>
        
        <!-- Manual link to go back -->
        <a href="${pageContext.request.contextPath}/index.jsp">Return to the homepage</a>
    </div>
</body>
</html>
