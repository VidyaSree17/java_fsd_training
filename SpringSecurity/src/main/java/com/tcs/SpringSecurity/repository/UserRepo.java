package com.tcs.SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.SpringSecurity.bean.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	public User findByUsername(String username);

}
