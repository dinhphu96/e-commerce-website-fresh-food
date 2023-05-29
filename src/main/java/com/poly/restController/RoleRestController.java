package com.poly.restController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bean.Role;
import com.poly.service.RoleService;



@CrossOrigin("*")
@RestController
public class RoleRestController {

	@Autowired
	RoleService roleService;
	
	@GetMapping("/rest/roles")
	public List<Role> findAll() {
		return roleService.findAll();
	}

}
