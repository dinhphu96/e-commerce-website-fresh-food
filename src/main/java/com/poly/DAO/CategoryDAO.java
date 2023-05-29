package com.poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.bean.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
