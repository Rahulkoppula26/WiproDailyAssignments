

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Demo")
public class DemoServlet extends HttpServlet {  
    public DemoServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * For Cookies this is the syntax and the data last for long run in cookies
		 * */
		for(Cookie obj1 : request.getCookies()) {
			if (obj1.getName().equalsIgnoreCase("username")) {
				response.getWriter().append("value stores in cookies : " + obj1.getValue() +"\n");
			}
		}
		
		/*
		 * For Session Storage this is the syntax and the data last for some duration for security puspose
		 * */
		    HttpSession  session= request.getSession();        
		    
		    String name= (String) session.getAttribute("username");
		    String password= (String) session.getAttribute("password");
		    
		    
		    response.getWriter().append("Seesion Storage Overview \n");
		    response.getWriter().append("Users Credentials : " + "\nName : " + name + "\nPassword : " +  password);

	}

}
