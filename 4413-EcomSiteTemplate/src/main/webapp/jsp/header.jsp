<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<!-- header.jsp -->
<link rel="stylesheet" type="text/css" href="css/header.css">

<header>
    <div class="title">
        <h1>THE VIBEZ</h1>
    </div>
    
    <div class="top-buttons">
    <!-- intitParam points to web.xml -> context-param param1 which goes to QueryServlet -->
		<a href="${initParam.param1}?action=allBooks">aLL BOOKS</a>
		<a href="${pageContext.request.contextPath}/jsp/login.jsp">Sign In</a>
        <a href="${pageContext.request.contextPath}/jsp/createAccount.jsp">Register</a>
     <!-- Make it so the Admin moves to login page if it is not logged in-->
        <a href="${pageContext.request.contextPath}/jsp/admin.jsp">Admin</a>

    </div>
    <div class="search-bar">
        <form action="search.jsp" method="get">
            <input type="text" name="query" placeholder="Search...">
            <input type="submit" value="Search">
        </form>
    </div>
    <nav>
		<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
        <a href="allclothes.jsp">All Clothes</a>
        <a href="#">Brands</a>
        <div class="dropdown">
            <a href="#">Brand 1</a>
            <a href="#">Brand 2</a>
            <a href="#">Brand 3</a>
        </div>
    </nav>
</header>
