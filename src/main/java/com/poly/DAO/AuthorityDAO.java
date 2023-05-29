package com.poly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.Account;
import com.poly.bean.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{

	@Query("select DISTINCT a from Authority a where a.account in ?1")
	List<Authority> authoritiesOf(List<Account> accounts);

}
