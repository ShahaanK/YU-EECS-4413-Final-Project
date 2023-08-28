<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/loginDraw.css">
    
    <title>Sign In</title>
</head>
<body>
    <div class="header">
         <h1><a href="/4413-EcomSiteTemplate">THE VIBEZ</a></h1>
    </div>
    
    <div class="main-content">
        <h1>Sign In</h1>
        
        <div class="login-error">
            <% String loginError = (String) request.getAttribute("loginError");
            if (loginError != null) { %>
                <p><strong><%= loginError %></strong></p>
            <% } %>
            
            <% String alreadyLoggedInError = (String) request.getAttribute("alreadyLoggedInError");
            if (alreadyLoggedInError != null) { %>
                <p><strong><%= alreadyLoggedInError %></strong></p>
            <% } %>
        </div>
        
        <form action="/4413-EcomSiteTemplate/LoginSignInServlet" method="post">
            <input type="hidden" name="action" value="login">
            
            <label for="username">Username(email):</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <button class="login-button">Login</button>
        </form>
    </div>
</body>
</html>