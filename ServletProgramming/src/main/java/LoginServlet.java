

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		response.getWriter().append("Users Credentials : " + "\nName : " + username + "\nPassword : " +  password);
//		
//		//Cookie Management and syntax
//		Cookie obj1 = new Cookie("username", username);
//		Cookie obj2 = new Cookie("password", password);
//		obj1.setMaxAge(30 * 60);
//		obj2.setMaxAge(30 * 60);
//		response.addCookie(obj1);
//		response.addCookie(obj2);
//		
//		// Session management ans syntax
//		HttpSession session = request.getSession();
//		session.setAttribute("username", username);
//		session.setAttribute("password", password);
//		
//		
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Demo");
//		dispatcher.forward(request, response);
		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

//		String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1"; // Service Name
//		String USERNAME = "appuser";
//		String PASSWORD = "1234";
//		String query = "select * from users where username=? and password=?";
		
		String URL = "jdbc:mysql://localhost:3306/users";
		String USERNAME = "root";
		String PASSWORD = "root";
		String query = "select * from users where username=? and password=?";

		

		try {
			// Load Driver (optional in newer versions)
		
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connobj = DriverManager.getConnection(URL, USERNAME, PASSWORD); // step2
			connobj.setAutoCommit(true);
			PreparedStatement statement=connobj.prepareStatement(query);
			statement.setString(1, username.trim());
			statement.setString(2, password.trim());
			   ResultSet result= statement.executeQuery();
		     if(result.next())
		     {
		    	    request.setAttribute("username", result.getString("username"));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Profile.jsp");
					dispatcher.forward(request, response);
		     }
		     else
		     {
		    	  response.getWriter().append("Login failed"); 
		     }

		} catch (Exception e) {
		  response.getWriter().append("error : "+e);
		}


		
	}

}
