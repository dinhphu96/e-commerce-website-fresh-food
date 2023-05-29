package com.poly.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.AccountDAO;
import com.poly.DAO.AuthorityDAO;
import com.poly.bean.Account;
import com.poly.bean.Authority;
import com.poly.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	AuthorityDAO authorityDAO;
	@Autowired
	AccountDAO accountDAO;

	@Override
	public List<Authority> findAuthoritiesAdMinistation() {
		List<Account> accounts = accountDAO.getAdministrantors();
		return authorityDAO.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityDAO.findAll();
	}

	@Override
	public Authority save(Authority authority) {
		// TODO Auto-generated method stub
		return authorityDAO.save(authority);
	}

	@Override
	public void deleteById(Integer id) {
		authorityDAO.deleteById(id);
		
	}
	
	
}
