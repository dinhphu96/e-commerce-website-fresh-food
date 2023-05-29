package com.poly.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.AccountDAO;
import com.poly.bean.Account;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accountDAO;

	@Override
	public List<Account> getAdministrantors() {
		// TODO Auto-generated method stub
		return accountDAO.getAdministrantors();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountDAO.findAll();
	}
	
	
}
