<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <title>Already Logged In</title>
    <script>
        // Redirect to main page after 5 seconds
        setTimeout(function() {
            window.location.href = "${pageContext.request.contextPath}/index.jsp";
        }, 5000); // 5000 milliseconds = 5 seconds
    </script>
</head>
<body>
	<jsp:include page="header.jsp" />
	
    <h1>You are already logged in</h1>
    <p>Automatically redirecting to the home page in 3 seconds...</p>
    <p>If not redirected, you can <a href="${pageContext.request.contextPath}/index.jsp">click here</a> to return to the homepage.</p>
    

</body>
</html>



