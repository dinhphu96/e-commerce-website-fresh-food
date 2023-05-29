package com.poly.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bean.Category;
import com.poly.service.CategoryService;

@CrossOrigin("*")
@RestController
public class CategoryRestController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/rest/categories")
	public List<Category> getAll() {
		return categoryService.findAll();
	}
	
	@PostMapping("/rest/categories")
	public Category create(@RequestBody Category ca) {
		return categoryService.save(ca);
	}
	
	@PutMapping("/rest/categories/{id}")
	public Category update(@PathVariable("id") String id, @RequestBody Category ca) {
		return categoryService.update(ca);
	}
	
	@DeleteMapping("/rest/categories/{id}")
	public void delete(@PathVariable("id") String id) {
		categoryService.delete(id);
	}
	
//	@GetMapping("/rest/products/{id}")
//	public Product getOne(Model model, @PathVariable("id") Integer id) {
//		return productService.findById(id);
//	}
}
