package com.poly.service;

import java.util.List;

import com.poly.bean.Authority;

public interface AuthorityService {

	List<Authority> findAuthoritiesAdMinistation();

	List<Authority> findAll();

	Authority save(Authority authority);

	void deleteById(Integer id);


}
