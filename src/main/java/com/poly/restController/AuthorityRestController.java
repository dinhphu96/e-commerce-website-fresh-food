package com.poly.restController;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bean.Authority;
import com.poly.service.AuthorityService;



@CrossOrigin("*")
@RestController
public class AuthorityRestController {

	@Autowired
	AuthorityService authorityService;
	
	@GetMapping("/rest/authorities")
	public List<Authority> getAuthorities(@RequestParam("admin") Optional<Boolean> admin) {
		if(admin.orElse(false)) {
			System.out.println("Vào admin");
			return authorityService.findAuthoritiesAdMinistation();
		}
		return authorityService.findAll();
	}

	@DeleteMapping("/rest/authorities/{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityService.deleteById(id);
	}

	@PostMapping("/rest/authorities")
	public Authority create(@RequestBody Authority authority) {
		return authorityService.save(authority);
	}

}
