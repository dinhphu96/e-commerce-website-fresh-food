package com.poly.service;

import java.util.List;

import com.poly.bean.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product save(Product pr);

	Product update(Product pr);

	void delete(Integer id);

}
