package com.poly.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.CategoryDAO;
import com.poly.bean.Category;
import com.poly.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public Category save(Category ca) {
		return categoryDAO.save(ca);
	}

	@Override
	public Category update(Category ca) {
	return categoryDAO.save(ca);
	}

	@Override
	public void delete(String id) {
		categoryDAO.deleteById(id);
		
	}
	
	
}
