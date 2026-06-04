package com.wipro.ProductService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ProductService.Entity.Product;
import com.wipro.ProductService.Repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	public List<Product> allProducts(){
		return repo.findAll();
	}
	
	public Optional<Product> getProductById(long productId) {
		return repo.findById(productId);
	}
}
