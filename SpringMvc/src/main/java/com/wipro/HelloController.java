package com.wipro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello") // http://localhost:8080/ProjectName/hello
	public String getHello() {
		return "First"; // returning name of view page      WEB-INF/views/First.jsp
	}
	
	

	@RequestMapping("/welcome") // http://localhost:8080/ProjectName/welcome
	public String getWelcome() {
		return "Welcome"; // returning name of view page      WEB-INF/views/Dashboard.jsp
	}

}
