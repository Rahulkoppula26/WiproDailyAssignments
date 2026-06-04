package com.wipro.Food.DeliverySystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService{
	private PaymentService payment;
	
	@Autowired
	public OrderService(PaymentService payment) {
		this.payment = payment;
	}
	
	public void PlacingOrder() {
		System.out.println("Order Placed");
		payment.payment();
	}
}
