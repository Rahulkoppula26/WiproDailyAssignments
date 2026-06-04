<!-- file: index.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         errorPage="error.jsp" %>

<html>
<head>
    <title>Error Page Example</title>
</head>
<body>

<h2>Division Example</h2>

<form method="post">
    Enter First Number:
    <input type="text" name="num1"><br><br>

    Enter Second Number:
    <input type="text" name="num2"><br><br>

    <input type="submit" value="Divide">
</form>

<%
    String n1 = request.getParameter("num1");
    String n2 = request.getParameter("num2");

    if (n1 != null && n2 != null) {
        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);

        int result = a / b;   // if user enters 0, exception occurs

        out.println("<h3>Result = " + result + "</h3>");
    }
%>

</body>
</html>