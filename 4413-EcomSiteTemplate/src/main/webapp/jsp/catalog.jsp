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

<div>
		<c:if test="${param.price == null}" > 
		<!-- Need to update this shit so we get the brands instead -->
		 <span class="label" style="margin-left: 15px;"> List of ${param.category}  Books
		 </span>
		</c:if>
	</div>

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
	
