<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment result</title>
</head>
<body>
    <h1>Payment Result</h1>
    <c:if test="${not empty paymentMessage}">
        <p>${paymentMessage}</p>
        <c:choose>
            <c:when test="${paymentMessage == 'Order Successfully Completed.'}">
                <h2>Order Information:</h2>
                <!-- Display order details here -->
                <p>Order ID: ${orderID}</p>
                <!-- Add other order details as needed -->
                
                <h2>Payment Information:</h2>
                <!-- Display payment details here -->
                <p>Payment ID: ${paymentID}</p>
                <p>Card Number: ${cardNumber}</p>
                <p>Expiration Date: ${expirationDate}</p>
                <p>CVV: ${cvv}</p>
            </c:when>
            <c:otherwise>
                <p class="error">Credit Card Authorization Failed.</p>
            </c:otherwise>
        </c:choose>
        <a href="${pageContext.request.contextPath}/jsp/payment.jsp">Try Again</a>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <p class="error">${errorMessage}</p>
        <a href="${pageContext.request.contextPath}/jsp/payment.jsp">Try Again</a>
    </c:if>
    <a href="${pageContext.request.contextPath}/index.jsp">Back to Home</a>
</body>
</html>
