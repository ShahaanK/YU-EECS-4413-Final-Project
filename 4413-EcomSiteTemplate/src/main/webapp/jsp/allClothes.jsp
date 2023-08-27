<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Clothes</title>
    <link rel="stylesheet" type="text/css" href="allClothestyles.css"> <!-- Link your custom CSS stylesheet here -->
</head>
<body>
    <!-- Header -->
    <jsp:include page="header.jsp"/>

    <!-- Product Grid -->
    <div class="product-grid">
        <c:forEach var="item" items="${itemList}">
            <div class="product">
                <div class="product-image">
                    <img src="<c:out value='${item.image}' />" alt="<c:out value='${item.productName}' />">
                </div>
                <div class="product-details">
                    <h2><c:out value="${item.productName}" /></h2>
                    <p>Price: $<c:out value="${item.price}" /></p>
                    <p>Brand: <c:out value="${item.brand}" /></p>
                    <p>Category: <c:out value="${item.category}" /></p>
                    <button>Add to Cart</button>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
