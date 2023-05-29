package com.poly.service;

import java.util.List;

import com.poly.bean.Category;

public interface CategoryService {

	List<Category> findAll();

	Category save(Category ca);

	Category update(Category ca);

	void delete(String id);

}
