package com.tcs.ReservationManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ReservationManagementSystem.bean.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, String>{

	public List<Vehicle> findByOwnerName(String ownerName);
}
