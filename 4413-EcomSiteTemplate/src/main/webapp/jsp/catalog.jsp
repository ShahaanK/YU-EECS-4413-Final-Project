<!-- catalog.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
 
<div class="catalog">
	<form action="QueryServlet" method="post">
    	<input type="hidden" name="action" value="sortPriceHighToLow">
        <button type="submit" name="action" value="sortPriceHighToLow">Sort by Price (High to Low)</button>
    </form>
	<!-- Add buttons or forms for sorting -->
    <form action="QueryServlet" method="post">
    	<input type="hidden" name="action" value="sortPriceLowToHigh">
        <button type="submit" name="action" value="sortPriceLowToHigh">Sort by Price (Low to High)</button>
    </form> 
    
    <form action="QueryServlet" method="post">
    	<input type="hidden" name="action" value="sortNameAZ">
        <button type="submit" name="action" value="sortNameAZ">Sort by Name (A To Z)</button>
    </form>      

	<!-- Add forms for searching -->
	<form action="QueryServlet" method="post">
		<input type="hidden" name="action" value="search">
		<input type="text" name="keyWord" placeholder="Search...">
		<button type="submit">Search</button>
	</form>
</div>

      <!-- Display the list of items -->
    <table id="grid">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Color</th>
                <th>Brand</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Category</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over itemList and display items -->
            <c:forEach var="item" items="${itemList}">
                <tr>
                    <td><c:out value="${item.productID}"/></td>
                    <td><c:out value="${item.productName}"/></td>
                    <td><c:out value="${item.colour}"/></td>
                    <td><c:out value="${item.brand}"/></td>
                    <td><c:out value="${item.quantity}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td><c:out value="${item.category}"/></td>
                    <td><img src="<c:out value="${item.image}"/>" alt="<c:out value="${item.productName}"/>"></td>
                </tr>
           </c:forEach>
        </tbody>
    </table>
</body>
</html>
	
<%--	<div class="products">
		<div class="product">
			<img src="dummy1.jpg" alt="Product 1">
			<div class="product-info">
				<p>Product 1</p>
				<p>$10</p>
				<button>Add</button>
			</div>
		</div>
		<!-- More products -->
		<div class="product">
			<img src="dummy2.jpg" alt="Product 2">
			<div class="product-info">
				<p>Product 2</p>
				<p>$20</p>
				<button>Add</button>
			</div>
		</div>
		<div class="product">
			<img src="dummy3.jpg" alt="Product 3">
			<div class="product-info">
				<p>Product 3</p>
				<p>$30</p>
				<button>Add</button>
			</div>
		</div>
		<div class="product">
			<img src="dummy4.jpg" alt="Product 4">
			<div class="product-info">
				<p>Product 4</p>
				<p>$40</p>
				<button>Add</button>
			</div>
		</div>
		<div class="product">
			<img src="dummy5.jpg" alt="Product 5">
			<div class="product-info">
				<p>Product 5</p>
				<p>$50</p>
				<button>Add</button>
			</div>
		</div>
		<div class="product">
			<img src="dummy6.jpg" alt="Product 6">
			<div class="product-info">
				<p>Product 6</p>
				<p>$60</p>
				<button>Add</button>
			</div>
		</div>
	</div>

--%> 
