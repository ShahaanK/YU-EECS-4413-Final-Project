<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Main Page</title>
<link rel="stylesheet" type="text/css" href="css/randomHome.css">
<!-- Link to your CSS file -->
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="main-content">
		<div class="random-items">
			<c:forEach items="${randomItems}" var="item">
				<div class="item">
					<img src="images/${item.image}" alt="${item.productName}">
					<p>${item.productName}</p>
					<p>Price: $${item.price}</p>
					<p>Brand: ${item.brand}</p>
					<p>Category: ${item.category}</p>

					<button type="submit">Add to Cart</button>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
