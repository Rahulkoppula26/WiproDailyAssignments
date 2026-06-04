<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Employees Data</title>

<style>
body {
	background: #f4f6f9;
	font-family: Arial, sans-serif;
}

.employee-card {
	border: none;
	border-radius: 15px;
	height: 245px;
	padding: 25px;
	text-align: center;
	overflow: hidden;
	transition: all 0.3s ease;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
}

.employee-card:hover {
	transform: translateY(-8px);
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
}

.employee-img {
	width: 90px;
	height: 90px;
	object-fit: cover;
	border-radius: 50%;
	margin: 0 auto 20px auto;
}

.card-body {
	text-align: center;
	padding: 0;
}

.emp-name {
	font-size: 20px;
	font-weight: bold;
	margin-top: 5px;
}

.emp-role {
	color: #6c757d;
	font-size: 16px;
}

.badge-custom {
	background: #0d6efd;
	padding: 5px 14px;
	border-radius: 20px;
	color: white;
	font-size: 14px;
}
</style>
</head>

<body>
	<%
	String user = (String) session.getAttribute("user");

	if (user == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	%>
	<div class="container mt-4">
		<div class="row">
			<%
			String action = request.getParameter("action");

			String URL = "jdbc:mysql://localhost:3306/usersData";
			String USERNAME = "root";
			String PASSWORD = "root";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connobj = DriverManager.getConnection(URL, USERNAME, PASSWORD);

				Statement statement = connobj.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM usersData");

				while (result.next()) {
			%>
			<div class="col-md-3 mb-4">
				<div class="card employee-card">
					<img src="<%=result.getString("imageUrl")%>" class="employee-img">

					<div class="card-body">
						<div class="emp-name"><%=result.getString("username")%></div>
						<div class="emp-role"><%=result.getString("designation")%></div>

						<span class="badge badge-custom mt-2"> <%=result.getString("department")%>
						</span>
					</div>
				</div>
			</div>

			<%
			}

			} catch (Exception e) {
			%>

			<h4 class="text-danger text-center">
				Error:
				<%=e.getMessage()%>
			</h4>

			<%
			}
			%>
		</div>
	</div>

</body>
</html>