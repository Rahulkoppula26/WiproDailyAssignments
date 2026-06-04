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
	width: 300px;
	overflow: hidden;
	transition: all 0.3s ease;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
}

.employee-card:hover {
	transform: translateY(-8px);
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
}

.employee-img {
	height: 150px;
	object-fit: cover;
	padding: 20px;
}

.card-body {
	text-align: center;
	padding: 15px;
}

.emp-name {
	font-size: 20px;
	font-weight: bold;
	margin-top: 10px;
}

.emp-role {
	color: #6c757d;
	font-size: 14px;
}

.badge-custom {
	background: #0d6efd;
	padding: 5px 10px;
	border-radius: 20px;
	color: white;
	font-size: 12px;
}
</style>
</head>
<body>
	<div class="container mt-4 text-center">
		<form method="get">
			<button type="submit" name="action" value="getData"
				class="btn btn-primary">Get Employee Data</button>
		</form>
	</div>
	<div class="container mt-4">
		<div class="row">
			<%
			String action = request.getParameter("action");

			if ("getData".equals(action)) {

				String URL = "jdbc:mysql://localhost:3306/usersData";
				String USERNAME = "root";
				String PASSWORD = "root";
				String query = "INSERT INTO usersData (imageUrl, username, designation, department) VALUES (?,?,?,?)";

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connobj = DriverManager.getConnection(URL, USERNAME, PASSWORD);

					Statement stmt = connobj.createStatement();
					ResultSet result = stmt.executeQuery("SELECT * FROM usersData");

					while (result.next()) {
			%>
			<div class="col-md-4 mb-4">
				<div class="card employee-card">
					<img src="<%=result.getString("imageUrl")%>"
						class="card-img-top employee-img">
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
			%>
		</div>
	</div>
	<%
	} catch (Exception e) {
		%>
		<h4>e.getMessage()</h4>
	<% 
	}

	}
	%>
</body>
</html>