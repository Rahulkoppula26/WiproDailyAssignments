

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
    public RegisterServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String eamil = request.getParameter("email");
		String password = request.getParameter("password");

//		String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
//		String USERNAME = "appuser";
//		String PASSWORD = "1234";
//		String query = "insert into users (username, email, password) values (?,?,?)";
		
		String URL = "jdbc:mysql://localhost:3306/users";
		String USERNAME = "root";
		String PASSWORD = "root";
		String query = "insert into users values(?,?,?)";


		try {
			// Load Driver (optional in newer versions)
		
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connobj = DriverManager.getConnection(URL, USERNAME, PASSWORD); // step2
			connobj.setAutoCommit(true);
			PreparedStatement statement = connobj.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, eamil);
			statement.setString(3, password);

			int rows = statement.executeUpdate();

			if (rows > 0) {
			    System.out.println("Insert successful");
			} else {
			    System.out.println("Insert failed");
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.html");
			dispatcher.forward(request, response);
			

		} catch (Exception e) {
		  response.getWriter().append("eror : "+e);
		}
	}

}
