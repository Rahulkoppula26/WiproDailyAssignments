package com.wipro;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileData {
	
	@RequestMapping("Login")
	public String Login() {
		return "Login";
	}
	
	@RequestMapping("Signup")
	public String Signup() {
		return "Signup";
	}
	
	 @RequestMapping("Profile")
	public ModelAndView profile() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Profile");                   //view page name
		mv.addObject("username","Koppula Rahul");   // data send in key value pair 
		mv.addObject("imageurl","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIq5SjiZzvoZEvd_G5tgEpGBgvPuRn2R52AQ&s");  
		mv.addObject("designation","Developer");  
		return mv;
		
	}
}
