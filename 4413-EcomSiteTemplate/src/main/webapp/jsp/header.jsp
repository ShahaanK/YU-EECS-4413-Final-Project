<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- header.jsp -->
<header>
    <div class="title">
        <h1>THE VIBEZ</h1>
    </div>
    <div class="top-buttons">
        <a href="login.jsp">Sign In</a>
        <a href="register.jsp">Register</a>
        <a href="admin.jsp">Admin</a>
    </div>
    <div class="search-bar">
        <form action="search.jsp" method="get">
            <input type="text" name="query" placeholder="Search...">
            <input type="submit" value="Search">
        </form>
    </div>
    <nav>
        <a href="index.html">Home</a>
        <a href="allclothes.jsp">All Clothes</a>
        <a href="#">Brands</a>
        <div class="dropdown">
            <a href="#">Brand 1</a>
            <a href="#">Brand 2</a>
            <a href="#">Brand 3</a>
        </div>
    </nav>
</header>
