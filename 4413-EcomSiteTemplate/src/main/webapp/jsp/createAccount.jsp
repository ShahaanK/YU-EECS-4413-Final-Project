<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Creation</title>
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
            padding: 3em;
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
        input[type="email"],
        input[type="tel"],
        input[type="password"] {
            width: 100%;
            padding: 0.5em;
            margin: 0.3em 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .create-account-button {
            display: block;
            width: 100%;
            padding: 0.5em;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .create-account-button:hover {
            background-color: #2980b9;
        }

        .login-link {
            display: block;
            text-align: center;
            margin-top: 1em;
        }
               /* Styles for select element */
        select {
            width: 100%;
            padding: 0.5em;
            margin: 0.3em 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

    </style>
    <script>
        function toggleFields() {
            var accountType = document.getElementById("accountType").value;
            var adminFields = document.querySelectorAll(".admin-fields");
            var customerFields = document.querySelectorAll(".customer-fields");

            if (accountType === "admin") {
                adminFields.forEach(function(field) {
                    field.classList.remove("hidden");
                });
                customerFields.forEach(function(field) {
                    field.classList.add("hidden");
                });
            } else {
                adminFields.forEach(function(field) {
                    field.classList.add("hidden");
                });
                customerFields.forEach(function(field) {
                    field.classList.remove("hidden");
                });
            }
        }
    </script>
</head>
<body>
    <div class="header">
       <a href="/4413-EcomSiteTemplate"> <h1>THE VIBEZ</a></h1>
    </div>
    
    <div class="main-content">
        <h1>Create an Account</h1>
        <form action="/4413-EcomSiteTemplate/LoginServlet" method="post">
            <input type="hidden" name="action" value="register">
            <select id="accountType" name="accountType" onchange="toggleFields()">
                <option value="customer">Customer</option>
                <option value="admin">Admin</option>
            </select>
            <input type="text" name="firstName" placeholder="First Name" class="admin-fields hidden">
            <input type="text" name="lastName" placeholder="Last Name" class="admin-fields hidden">
            <input type="email" name="email" placeholder="Email Address" class="admin-fields hidden">
            <input type="password" name="password" placeholder="Password" class="admin-fields hidden">
            <input type="password" name="confirmPassword" placeholder="Re-enter Password" class="admin-fields hidden">
            
            <input type="text" name="address" placeholder="Address" class="customer-fields">
            <input type="text" name="city" placeholder="City" class="customer-fields">
            <input type="text" name="province" placeholder="Province" class="customer-fields">
            <input type="text" name="country" placeholder="Country" class="customer-fields">
            <input type="text" name="postalCode" placeholder="Postal Code" class="customer-fields">
            <input type="tel" name="phoneNumber" placeholder="Phone Number" class="customer-fields">
            
            <button class="create-account-button">Create Account</button>
        </form>
        
        <a class="login-link" href="/4413-EcomSiteTemplate/jsp/login.jsp">Already have an account? Login here</a>
    </div>
</body>
</html>