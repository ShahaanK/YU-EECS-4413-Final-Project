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
    
    <form action="cart.jsp" method="post">
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
                            <input type="number" name="quantity_<%= item.getProductID() %>" value="<%= item.getQuantity() %>" min="1" class="quantity-input">
                            <button type="submit" name="update" value="<%= item.getProductID() %>" class="update-button">Update</button>
                        </td>
                        <td><%= item.getPrice() %></td>
                        <td>
                            <button type="submit" name="remove" value="<%= item.getProductID() %>" class="remove-button">Remove</button>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </form>
    
    <div class="footer-buttons">
        <form action="index.html" method="get">
            <button type="submit" class="continue-button">Continue Shopping</button>
        </form>
        
        <form action="finalCheckout.jsp" method="get">
            <button type="submit" class="checkout-button">Proceed to Checkout</button>
        </form>
    </div>
</body>
</html>
