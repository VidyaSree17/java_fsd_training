package com.tcs.ReservationManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ReservationManagementSystem.bean.User;
import com.tcs.ReservationManagementSystem.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public User createUser(User user) {
        return repo.save(user);
	}
	
	public User getUser(String id) {
		return repo.getReferenceById(id);
	}
}
