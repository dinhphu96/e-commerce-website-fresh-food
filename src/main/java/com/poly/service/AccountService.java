package com.poly.service;

import java.util.List;

import com.poly.bean.Account;

public interface AccountService {

	List<Account> getAdministrantors();

	List<Account> findAll();

}
