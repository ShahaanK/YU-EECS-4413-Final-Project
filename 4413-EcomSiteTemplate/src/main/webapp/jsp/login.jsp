<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html> --%>

<!-- 
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="userType">User Type:</label>
        <select id="userType" name="userType">
            <option value="customer">Customer</option>
            <option value="admin">Admin</option>
        </select><br><br>
        
        <input type="submit" value="Login">
    </form>
</body>
</html>
 -->
 
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
        <<title>THE VIBEZ - Home</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
        <div class="header-right">
            <input type="text" placeholder="Search...">
            <button type="submit">Search</button>
        </div>
    </header>

    <!-- Navigation -->
    <nav>
        <a href="../index.jsp">Home</a>
        <a href="#">All Clothes</a>
        <select>
            <option value="brand1">Brand 1</option>
            <option value="brand2">Brand 2</option>
            <option value="brand3">Brand 3</option>
        </select>
    </nav>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Sign In</h1>
        <form action="login.jsp" method="post">
            <input type="text" name="name" placeholder="Email Address">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" value="Log In">
        </form>
    </div>

</body>
</html>
 