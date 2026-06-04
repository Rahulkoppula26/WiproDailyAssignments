<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String error = "";

String username = request.getParameter("username");
String password = request.getParameter("password");

String name = "koppularahul";
String userPassword = "12345";

if (username != null && password != null) {
    if (username.equals(name) && userPassword.equals(password)) {
        session.setAttribute("user", username);
        response.sendRedirect("EmployeeData.jsp");
        return;
    } else {
        error = "Invalid username or password";
    }
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: #f4f6f9;
}

.login-box {
    width: 400px;
    margin: 100px auto;
    padding: 30px;
    background: white;
    border-radius: 15px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
}
</style>
</head>

<body>

<div class="login-box">
    <h3 class="text-center mb-4">Login</h3>

    <form method="post">
        <div class="mb-3">
            <label>Username</label>
            <input type="text" name="username" class="form-control" required>
        </div>

        <div class="mb-3">
            <label>Password</label>
            <input type="password" name="password" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary w-100">Login</button>

        <p class="text-danger text-center mt-3"><%= error %></p>
    </form>
</div>

</body>
</html>