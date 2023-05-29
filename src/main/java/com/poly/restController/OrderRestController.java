package com.poly.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.Order;
import com.poly.bean.OrderDetail;
import com.poly.service.OrderService;

@CrossOrigin("*")
@RestController
public class OrderRestController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/rest/orders")
	public Order create(@RequestBody JsonNode orderJson) {
		return orderService.create(orderJson);
	}
	
	@GetMapping("/rest/orders/orderDetail/{id}")
	public List<OrderDetail> getOne(@PathVariable("id") Long id) {
		return orderService.findById(id).getOrderDetails();
	}
}
