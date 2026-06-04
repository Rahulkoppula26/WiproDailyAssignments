package com.wipro.ProductProject.Contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ProductProject.Entity.Product;
import com.wipro.ProductProject.Exceptions.ProductNotFoundException;
import com.wipro.ProductProject.Repository.ProductRepository;

@RestController("/api")
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	
	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product newProduct = repository.save(product);
		return ResponseEntity.ok(newProduct);
	}

	// Get all products.

	    @GetMapping("/products")
	    public ResponseEntity<List<Product>> getAllProducts() {
	        return ResponseEntity.ok(repository.findAll());
	    }
	    
	    @GetMapping("/products/salaryconditonfilter")
	    public ResponseEntity<List<Product>> getAllProductAboveLimit(){
	    	List<Product> products = repository.findAll();
	    	List<Product> newList = products.stream().filter(prod -> prod.getPrice() > 5000).toList();
	    	return ResponseEntity.ok(newList);
	    }

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id){
		 return repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with Id : "+id+" is not found"));
	}
	
	   // Update a product by ID.
    
    @PutMapping("/products/{id}")
    
    //public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    	 return repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with Id : "+id+" is not found"));
//    	Optional<Product> obj = repository.findById(product.getId());
//		if (obj.isPresent()) {
//            
//			repository.save(product);
//			
//		}
//        return ResponseEntity.ok(obj.get());
    }
    
    @PatchMapping("/product/{id}")
    public ResponseEntity<Product> updateProductField(@PathVariable Long id, @RequestParam String product, @RequestParam int price) {
		Optional<Product> obj = repository.findById(id);
		if (obj.isPresent()) {
			Product product2 = obj.get();
			
			product2.setProduct(product);
			product2.setPrice(price);
			repository.save(product2);
			return ResponseEntity.ok(product2);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
}
