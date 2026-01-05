package com.tcs.ReservationManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ReservationManagementSystem.bean.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
