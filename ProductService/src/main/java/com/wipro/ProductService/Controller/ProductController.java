package com.wipro.ProductService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.ProductService.Entity.Product;
import com.wipro.ProductService.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	@PostMapping("/add")
	public Product saveProduct(@RequestBody Product product) {
		return  service.saveProduct(product);
	}
	@GetMapping
	 public List<Product> getAllProducts() {
	    return service.allProducts();
	 }
	  
	@GetMapping("/{productId}")
	public Optional<Product> getProductById(@PathVariable long productId) {
		return service.getProductById(productId);
	}

	
	
}
