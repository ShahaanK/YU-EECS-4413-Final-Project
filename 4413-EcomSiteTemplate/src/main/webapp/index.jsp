<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>THE VIBEZ - Home</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <style>
        /* Add your custom styles here */
        .welcome-link {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            font-size: 48px; /* Larger font size */
            font-weight: bold;
            cursor: pointer;
            text-decoration: none; /* Remove underline */
            color: #000; /* Set link color */
        }
    </style>
</head>
<body>

    <!-- Include header.jsp -->
    <jsp:include page="jsp/header.jsp" />

    <!-- Clickable Welcome Text -->
    <a href="/4413-EcomSiteTemplate/QueryServlet?action=main" class="welcome-link">Welcome to THE VIBEZ</a>

</body>
</html>
