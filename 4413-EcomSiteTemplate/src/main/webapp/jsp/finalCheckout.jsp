<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation_TEMP</title>
</head>
<body>
    <h1>Order Confirmation</h1>
    <p>Your order has been successfully placed. Here are the details:</p>
    
    <table>
        <tr>
            <th>Order ID</th>
            <th>Date of Purchase</th>
            <th>Total Price</th>
        </tr>
        <tr>
            <td>${order.id}</td>
            <td>${order.dateOfPurchase}</td>
            <td>${order.totalPrice}</td>
        </tr>
    </table>
    
    <p>Thank you for shopping with us!</p>
</body>
</html>
