package com.microservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	@Query("SELECT u from Users u where u.first_name like %:first_name%")
	List<Users> getUsersByFirstName(@Param("first_name") String first_name);
	
	@Query("SELECT u from Users u where u.username = :username")
	Users getUsersByUsername(@Param("username") String username);
	
	@Query(" SELECT u from Users u where u.is_active = true")
	List<Users> findActiveUser();
	
	@Query(" SELECT u from Users u where u.is_active = false")
	List<Users> findInactiveUser();
	
	@Query(" DELETE FROM Users u where username = :username")
	void deteleByUsername(@Param("username") String username);

}
