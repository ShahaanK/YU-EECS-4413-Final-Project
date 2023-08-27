<%@ page import="model.Cart, model.Item" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Your Shopping Cart</h1>
    
    <form action="CartServlet" method="post">
        <table class="cart-table">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Image</th>
                    <th>Product ID</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                Cart cart = (Cart) session.getAttribute("cart");
                for (Item item : cart.getItems()) { 
                %>
                    <tr>
                        <td><%= item.getProductName() %></td>
							<td><img src="<%= item.getImage() %>" alt="<%= item.getProductName() %>" class="product-image"></td>
							<td><%= item.getProductID() %></td>
							<td>
							    <form action="CartServlet" method="post">
							        <input type="hidden" name="action" value="update">
							        <input type="hidden" name="productID" value="<%= item.getProductID() %>">
							        <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" class="quantity-input">
							        <button type="submit" class="update-button">Update</button>
							    </form>
							</td>
							<td><%= item.getPrice() %></td>
							<td>
							    <form action="CartServlet" method="post">
							        <input type="hidden" name="action" value="remove">
							        <input type="hidden" name="productID" value="<%= item.getProductID() %>">
							        <button type="submit" class="remove-button">Remove</button>
							    </form>
							</td>

                    </tr>
                <% } %>
            </tbody>
        </table>
    </form>
    
    <div class="footer-buttons">
        <form action="index.jsp" method="get">
            <button type="submit" class="continue-button">Continue Shopping</button>
        </form>
        
        <!-- Link to the payment page -->
       <a href="${pageContext.request.contextPath}/jsp/payment.jsp"class="checkout-button">Proceed to Checkout</a>
    </div>
</body>
</html>
