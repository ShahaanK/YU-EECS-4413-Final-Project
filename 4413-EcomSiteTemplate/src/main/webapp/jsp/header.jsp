<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<!-- header.jsp -->
<link rel="stylesheet" type="text/css" href="css/index.css">

<header>
<div class="test1">
    <div class="title">
        <h1>THE VIBEZ</h1>
    </div>
    
    <div class="top-buttons">
    <!-- intitParam points to web.xml -> context-param param1 which goes to QueryServlet -->
        <a href="${pageContext.request.contextPath}/jsp/cart.jsp">
            <img src="images/icon/icon.png" alt="Shopping Cart">
        </a>
    
		<a href="${pageContext.request.contextPath}/jsp/login.jsp">Sign In</a>
        <a href="${pageContext.request.contextPath}/jsp/createAccount.jsp">Register</a>
     <!-- Make it so the Admin moves to login page if it is not logged in-->
        <a href="${pageContext.request.contextPath}/jsp/admin.jsp">Admin</a>

    </div>
    <div class="search-bar">
        <form action="/4413-EcomSiteTemplate/QueryServlet" method="post">
        	<input type="hidden" name="action" value="search">
        	<input type="text" name="keyWord" placeholder="Search...">
            <input type="submit" value="Search">
        </form>
    </div>
    <nav>
		<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
        <a href="/4413-EcomSiteTemplate/QueryServlet?action=allItems">All Clothes</a>
        <a href="#">Brands</a>
        <div class="dropdown">
            <a href="#">Brand 1</a>
            <a href="#">Brand 2</a>
            <a href="#">Brand 3</a>
        </div>
        <a href="#">Category</a>
        <div class="dropdown">
            <a href="/4413-EcomSiteTemplate/QueryServlet?action=allTops">Top</a>
            <a href="/4413-EcomSiteTemplate/QueryServlet?action=allBottoms">Button</a>
        </div>
    </nav>
    <div class="sortButton">
    <!-- Sorting options -->
    <!-- Sorting options -->
    <!--<form action="QueryServlet" method="post">
        <input type="hidden" name="action" value="sortPriceHighToLow">
        <button type="submit">Sort by Price (High to Low)</button>
    </form>
    <form action="QueryServlet" method="post">
        <input type="hidden" name="action" value="sortPriceLowToHigh">
        <button type="submit">Sort by Price (Low to High)</button>
    </form>
    <form action="QueryServlet" method="post">
        <input type="hidden" name="action" value="sortNameAZ">
        <button type="submit">Sort by Name (A To Z)</button>
    </form>
    -->

    <!-- Search form -->
</div>
</div>
</header>
