package com.example.event.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.event.model.Order;
import com.example.event.service.OrderService;
@RestController
public class OrderController {
@Autowired
private OrderService orderservice;

@GetMapping("/orders/{id}")
public Order getorder(@PathVariable String id) {
	
	Order order= orderservice.findOrderByCode(id);	
			
	return order;
}
@PostMapping("/orders")
public Order createorder(@RequestBody Order order) {
	
	orderservice.addOrder(order);
			
	return order;		
	
}
@GetMapping("/orders") 
public List<Order> getAllOrders() {
	
List<Order> orders= orderservice.getAllOrders();
	
	return orders;		
	
}

@DeleteMapping("/orders/{id}")
public void deleteOrder(@PathVariable String id) {
	
	orderservice.deleteOrder(id);
	
}
@PutMapping("/orders/{id}") 
public Order updateOrder(@RequestBody Order order ) {
	
	orderservice.updateOrder(order) ;
			
	return order;
}


}
