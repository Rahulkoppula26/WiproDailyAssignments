package com.wipro.UserService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserCont {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/all")
	public String getUser() {

		String response = restTemplate.getForObject("http://ProductService/product", String.class);

		return "Response from Product Service : " + response;
	}
}