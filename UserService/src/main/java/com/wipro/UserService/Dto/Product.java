package com.wipro.UserService.Dto;

public class Product {
	
	    private Long productId;
	    private String product;
	    private int price;
	    private int quantity;

	    public Product() {
	    }

	    public Long getId() {
	        return productId;
	    }

	    public void setId(Long productId) {
	        this.productId = productId;
	    }

	    public String getProduct() {
	        return product;
	    }

	    public void setProduct(String product) {
	        this.product = product;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
}
