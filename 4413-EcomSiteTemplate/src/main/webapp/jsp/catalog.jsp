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
	<div class="filters">
		<button>Low to High</button>
		<button>High to Low</button>
		<button>A-Z</button>
	</div>
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
	<div>
		<c:if test="${param.category != null}" > 
		 <span class="label" style="margin-left: 15px;"> List of ${param.category}  Books
		 </span>
		</c:if>
	</div>

	 
	<table id="grid">
		<thead>
			<tr>
			<%-- Need more headers --%>
				<th id="th-title">Book Title</th>
				<th id="th-author">Author(s)</th>
				<th id="th-author1">Category</th>
				
			</tr>
		</thead>


		<tbody>
		
			
        <!-- This is where we loop through the cart or productList-->
			<c:forEach var="x" items="${itemList}">
				<tr>
					<%-- Need more headers --%>
				
					<td><c:out value="${x.bookTitle}"/></td>
					<td><c:out value="${x.author.firstName} ${x.author.lastName}"/></td>
					<td><c:out value="${x.category}"/></td>
				</tr>
			</c:forEach>
	 

		</tbody>

	</table>
</div>
</body>
</html>