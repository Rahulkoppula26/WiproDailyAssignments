package com.wipro.ProductService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.ProductService.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
