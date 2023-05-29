package com.poly.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.ProductDAO;
import com.poly.bean.Product;
import com.poly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> findAll() {
		List<Product> list = productDAO.findAll();
		return list;
	}

	@Override
	public Product findById(Integer id) {
		return productDAO.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		
		return productDAO.findByCategoryId(cid);
	}

	@Override
	public Product save(Product pr) {
		// TODO Auto-generated method stub
		return productDAO.save(pr);
	}

	@Override
	public Product update(Product pr) {
		// TODO Auto-generated method stub
		return productDAO.save(pr);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productDAO.deleteById(id);;
	}


}
