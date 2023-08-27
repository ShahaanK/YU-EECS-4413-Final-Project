<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Result</title>
    <style>
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

        p {
            margin: 1em 0;
            padding: 0 1em;
        }

        .success {
            color: #4caf50;
        }

        .error {
            color: #f44336;
        }

        a {
            display: inline-block;
            margin: 1em;
            text-decoration: none;
            color: #343a40;
            border: 1px solid #343a40;
            padding: 0.5em 1em;
            border-radius: 4px;
        }

        a:hover {
            background-color: #343a40;
            color: white;
        }
    </style>
</head>
<body>
    <h1>Payment Result</h1>
    <c:if test="${not empty paymentMessage}">
        <p class="${paymentMessage == 'Order Successfully Completed.' ? 'success' : 'error'}">${paymentMessage}</p>
        <c:choose>
            <c:when test="${paymentMessage == 'Order Successfully Completed.'}">
                <h2>Order Information:</h2>
                <p>Order ID: ${orderID}</p>
                <!-- Add other order details as needed -->

                <h2>Payment Information:</h2>
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
