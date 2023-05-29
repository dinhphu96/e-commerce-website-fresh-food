package com.poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/checkout")
	public String checkout(Model model) {
		
		return "order/checkout";
	}
	
	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/orderList";
	}
	
//	@RequestMapping("/order/detail/{id}")
//	public String detail(Model model, @PathVariable("id") Integer id) {
//		model.addAttribute("phu", "orderdetail id ="+id);
//		return "order/list";
//	}
}
