package com.cos.testblog.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


// DAO

public interface UserRepository extends JpaRepository<User, Integer> { // Generic , PK의 타입
	
	@Query(value = "insert into user (username, password, email) values (:username, :password, :email)", nativeQuery = true)
	void join(String username, String password, String email);	
	

	@Query(value = "select * from user where username = :username and password = :password", nativeQuery = true )
	User mLogin(String username, String password);    
	
}
