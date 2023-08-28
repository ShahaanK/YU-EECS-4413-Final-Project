<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .header {
            background-color: #3498db;
            color: white;
            text-align: center;
            padding: 1em;
        }

        .main-content {
            max-width: 400px;
            margin: 2em auto;
            padding: 1em;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 1em;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 0.5em;
            margin: 0.3em 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .login-button {
            display: block;
            width: 100%;
            padding: 0.5em;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .login-button:hover {
            background-color: #2980b9;
        }

        .login-error {
            color: red;
            text-align: center;
            margin-top: 1em;
        }
    </style>
</head>
<body>
    <div class="header">
        <a href="/4413-EcomSiteTemplate"> <h1>THE VIBEZ</a></h1>
    </div>
    
    <div class="main-content">
        <h1>Sign In</h1>
        
        <div class="login-error">
            <% String loginError = (String) request.getAttribute("loginError");
            if (loginError != null) { %>
                <p><strong><%= loginError %></strong></p>
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
