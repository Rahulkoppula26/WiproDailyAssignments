package com.wipro.SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/message")
	public String getMessage(Model obj) {
		obj.addAttribute("msg", "welcome!");
		return "home";
		
	}
}