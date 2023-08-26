<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- header.jsp -->
<header>
    <div class="title">
        <h1>THE VIBEZ</h1>
    </div>
    <div class="top-buttons">
        <a href="signin.jsp">Sign In</a>
        <a href="register.jsp">Register</a>
        
        <!-- Make it so the Admin moves to login page if it is not logged in-->
        <a href=".../js/admin.jsp">Admin</a>
        <% 
            // Replace with your actual logic for login confirmation and ID check
            boolean isLoginConfirmed = true; // This should come from your authentication logic
            String userId = "123"; // This should come from your authentication logic
            if (isLoginConfirmed && "13".equals(userId)) {
        %>
            <a href="adminSalesList.jsp">Analytics</a>
        <% 
            }
        %>
    </div>
    <div class="search-bar">
        <form action="search.jsp" method="get">
            <input type="text" name="query" placeholder="Search...">
            <input type="submit" value="Search">
        </form>
    </div>
    <nav>
		<a href="../index.jsp">Home</a>
        <a href="allclothes.jsp">All Clothes</a>
        <a href="#">Brands</a>
        <div class="dropdown">
            <a href="#">Brand 1</a>
            <a href="#">Brand 2</a>
            <a href="#">Brand 3</a>
        </div>
    </nav>
</header>
