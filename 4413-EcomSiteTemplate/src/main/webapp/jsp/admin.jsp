<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <title>Admin Page</title>
</head>
<body>
<jsp:include page="header.jsp" />
    <h1>Admin Page</h1>

    <h2>Payments</h2>
    <table border="1">
        <tr>
            <th>Payment ID</th>
            <th>Card Number</th>
            <th>Expiration</th>
            <th>CVV</th>
            <th>Order ID</th>
        </tr>
        <c:forEach var="payment" items="${payments}">
            <tr>
                <td>${payment.paymentID}</td>
                <td>${payment.cardNum}</td>
                <td>${payment.expir}</td>
                <td>${payment.cvv}</td>
                <td>${payment.orderID}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Orders</h2>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Customer ID</th>
            <th>Date of Purchase</th>
            <th>Total Price</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.customerID}</td>
                <td>${order.dateOfPurchase}</td>
                <td>${order.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
