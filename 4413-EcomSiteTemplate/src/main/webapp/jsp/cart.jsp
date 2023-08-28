<%@ page import="model.Cart, model.Item" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <!--FIX STYLE-->
    <style>
        /* Additional styles for the Shopping Cart page */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #343a40;
            color: white;
            padding: 1em;
            margin: 0;
            text-align: center;
        }

        .cart-table {
            width: 100%;
            border-collapse: collapse;
            margin: 1em 0;
            background-color: white;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .cart-table th, .cart-table td {
            padding: 0.5em;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        .cart-table th {
            background-color: #343a40;
            color: white;
        }

        .product-image {
            max-width: 100px;
            max-height: 100px;
        }

        .quantity-input {
            width: 50px;
            padding: 0.2em;
        }

        .update-button, .remove-button {
            background-color: #343a40;
            color: white;
            border: none;
            padding: 0.3em 0.5em;
            cursor: pointer;
        }

        .footer-buttons {
            text-align: center;
            margin-top: 2em;
        }

        .continue-button, .checkout-button {
            background-color: #343a40;
            color: white;
            border: none;
            padding: 0.5em 1em;
             margin: 1em 0;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-right: 1em;
        }
    </style>
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
                            <td><img src="images/<%= item.getImage() %>" alt="<%= item.getProductName() %>" class="product-image"></td>
                            <td><%= item.getProductID() %></td>
                            <td>
    <form action="CartServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="productIDToUpdate" value="<%= item.getProductID() %>">
        <input type="number" name="quantity_<%= item.getProductID() %>" value="<%= item.getQuantity() %>" min="1" class="quantity-input">
        <button type="submit" class="update-button">Update</button>
    </form>
</td>
<td>

<!-- Round the number -->
<%
    double unroundedValue = item.getPrice() * item.getQuantity();
    String roundedValue = String.format("%.2f", unroundedValue);
%>
<%= 
roundedValue%>

<!-- End Round the number -->

</td>
<td>
    <form action="CartServlet" method="post">
        <input type="hidden" name="action" value="remove">
        <input type="hidden" name="productIDToRemove" value="<%= item.getProductID() %>">
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
        <a href="${pageContext.request.contextPath}/jsp/payment.jsp" class="checkout-button">Proceed to Checkout</a>
    </div>
</body>
</html>
