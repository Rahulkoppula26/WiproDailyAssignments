package com.wipro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String displayForm() {
		return "Form";
	}
	
	@PostMapping("/addStudent")
	public ModelAndView Submit(Student student) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student",student);
		
		if(student.getName().length() < 2) {
			modelAndView.setViewName("Error");
		}
		else if(!student.getEmail().contains("@gmail.com")) {
			modelAndView.setViewName("MainError");
		}
		else {
			modelAndView.setViewName("Success");
		}
		return modelAndView;
	}
	
}
