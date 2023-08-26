<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Account Creation</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

    <!-- Header -->
    <header>
        <span>My Webshop</span>
        <div class="header-right">
            <input type="text" placeholder="Search...">
            <button type="submit">Search</button>
        </div>
    </header>

    <!-- Navigation -->
    <nav>
        <a href="../index.html">Home</a>
        <a href="#">All Clothes</a>
        <select>
            <option value="brand1">Brand 1</option>
            <option value="brand2">Brand 2</option>
            <option value="brand3">Brand 3</option>
        </select>
    </nav>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Create an Account</h1>
        <form action="createAccount.jsp" method="post">
            <input type="text" name="name" placeholder="Name">
            <input type="text" name="address" placeholder="Address">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" value="Create Account">
        </form>
        <button class="login-button">Login</button>
    </div>

</body>
</html>
