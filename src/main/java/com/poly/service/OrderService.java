package com.poly.service;


import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.Order;


public interface OrderService {

	Order create(JsonNode orderJson);

	List<Order> findByUsername(String username);

	Order findById(Long id);
}
