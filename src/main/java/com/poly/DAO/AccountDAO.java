package com.poly.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.Account;

public interface AccountDAO extends JpaRepository<Account, String>{

//	public final static String GET_USER_BY_USERNAME = "SELECT * FROM heroku_844f026e121e684.USERS  WHERE FULLNAME like %:uName% AND role LIKE 'ROLE_USER'";
//	
//	
//	 @Query(value = GET_USER_BY_USERNAME,  nativeQuery = true)
//	  List<User> findByUserName(@Param("uName")final String uName);
	
	
	@Query("select a from Account a where a.username = ?1")
	Account findByUsername(String remoteUser);

	@Query("select DISTINCT ar.account from Authority ar where ar.role.id in ('DIRE','STAF')")
	List<Account> getAdministrantors();
}
