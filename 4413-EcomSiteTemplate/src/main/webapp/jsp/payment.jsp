<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
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
        
        form {
            background-color: white;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 2em auto;
            padding: 2em;
        }
        
        input[type="text"] {
            width: 100%;
            padding: 0.5em;
            margin-bottom: 1em;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
            font-size: 16px;
        }
        
        input[type="submit"] {
            background-color: #343a40;
            color: white;
            border: none;
            padding: 0.5em 1em;
            cursor: pointer;
            font-size: 16px;
        }
        
        input[type="submit"]:hover {
            background-color: #2d3238;
        }
    </style>
</head>
<body>
    <h1>Payment Information</h1>
    <form action="/4413-EcomSiteTemplate/PaymentServlet" method="post">
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" placeholder="xxxxxxxxxxxxxxxx" required><br>
        
        <label for="expirationDate">Expiration Date (MM/YYYY):</label>
        <input type="text" id="expirationDate" name="expirationDate" placeholder="mm/yy" required><br>
        
        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" placeholder="xxx" required><br>
        
        <input type="submit" value="Submit Payment">
    </form>
</body>
</html>
