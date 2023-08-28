<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/loginDraw.css">
    
    <title>Account Creation</title>
   
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
        <form action="/4413-EcomSiteTemplate/LoginSignInServlet" method="post">
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
            
            <button class="login-button">Create Account</button>
        </form>
        
        <button class="login-button" href="/4413-EcomSiteTemplate/jsp/login.jsp">Already have an account? Login here</button>
    </div>
</body>
</html>