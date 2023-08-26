<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Payment</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Payment</h1>
    
    <form action="ProcessPaymentServlet" method="post">
        <div class="payment-details">
            <label for="cardNumber">Card Number:</label>
            <input type="text" id="cardNumber" name="cardNumber" required>
        </div>
        <div class="payment-details">
            <label for="expirationDate">Expiration Date:</label>
            <input type="text" id="expirationDate" name="expirationDate" placeholder="MM/YYYY" required>
        </div>
        <div class="payment-details">
            <label for="cvv">CVV:</label>
            <input type="text" id="cvv" name="cvv" required>
        </div>
        
        <button type="submit" class="checkout-button">Complete Payment</button>
    </form>
</body>
</html>
