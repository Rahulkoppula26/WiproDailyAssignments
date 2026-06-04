<!-- file: error.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>

<html>
<head>
<title>Custom Error Page</title>
</head>
<body>

	<h2>Something Went Wrong!</h2>

	<p>
		Error Message:
		<%=exception%></p>

	<a href="DemoError.jsp">Go Back</a>

</body>
</html>