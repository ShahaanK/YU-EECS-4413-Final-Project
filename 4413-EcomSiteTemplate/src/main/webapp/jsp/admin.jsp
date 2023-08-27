<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Display payment information -->
<h2>Payment Information</h2>
<table>
    <thead>
        <tr>
            <th>Payment ID</th>
            <th>Card Number</th>
            <th>Expiration Date</th>
            <th>CVV</th>
            <th>Order ID</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="payment" items="${payments}">
            <tr>
                <td>${payment.paymentID}</td>
                <td>${payment.cardNum}</td>
                <td>${payment.expir}</td>
                <td>${payment.cvv}</td>
                <td>${payment.orderID}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Display order details -->
<h2>Order Details</h2>
<table>
    <thead>
        <tr>
            <th>Order ID</th>
            <th>Customer ID</th>
            <th>Date of Purchase</th>
            <th>Total Price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.customerID}</td>
                <td>${order.dateOfPurchase}</td>
                <td>${order.totalPrice}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>