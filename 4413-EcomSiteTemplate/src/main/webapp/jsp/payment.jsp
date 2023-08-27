<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
</head>
<body>
    <h1>Payment Information</h1>
    <form action="/4413-EcomSiteTemplate/PaymentServlet" method="post">
        Card Number: <input type="text" name="cardNumber" placeholder="xxxxxxxxxxxxxxxx" required><br>
        Expiration Date (MM/YYYY): <input type="text" name="expirationDate" placeholder="mm/yy" required><br>
        CVV: <input type="text" name="cvv" placeholder="xxx" required><br>
        <input type="submit" value="Submit Payment">
    </form>
</body>
</html>
