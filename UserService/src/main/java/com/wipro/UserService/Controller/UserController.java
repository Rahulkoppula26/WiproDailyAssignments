package com.wipro.UserService.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.UserService.Dto.Product;
import com.wipro.UserService.Entity.User;
import com.wipro.UserService.Service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	RestTemplate resttemplate;

	@Autowired
	UserService service;

	@PostMapping("/add")
	public User saveUser(@RequestBody User user) {
		return service.registerUser(user);
	}
	@GetMapping
	public List<User> getAllUsers() {
	    return service.getAllUsers();
	}
	
	@CircuitBreaker(name = "UserService", fallbackMethod = "getUserFallback")
	@GetMapping("/{id}")
	public Map<String, Object> getUserandProduct(@PathVariable Long id) {

		User userobj = service.getUser(id).orElse(null);

		String url = "http://ProductService/product/"+userobj.getProductId();
		Product prodobj = resttemplate.getForObject(url, Product.class);

		Map<String, Object> map = new HashMap<>();
		map.put("User", userobj);
		map.put("Product", prodobj);
		return map;

	}
	
	public Map<String, Object> getUserFallback(Long id, Exception e) {

        User userobj = service.getUser(id).orElse(null);

        Map<String, Object> map = new HashMap<>();

        map.put("User", userobj);
        map.put("Product", "Product Service is down");

        return map;
    }

	
	
}