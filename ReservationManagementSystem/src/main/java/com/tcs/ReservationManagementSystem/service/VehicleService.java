package com.tcs.ReservationManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ReservationManagementSystem.bean.Vehicle;
import com.tcs.ReservationManagementSystem.repository.VehicleRepo;

import jakarta.validation.Valid;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepo repo;
	
	public void saveVehicle(@Valid Vehicle vehicle) {
		repo.save(vehicle);
	}
	
	public Vehicle getVehicle(String vehicleId) {
		return repo.getReferenceById(vehicleId);
	}
	
	public List<Vehicle> findVehicleByOwner(String ownerName){
		return repo.findByOwnerName(ownerName);
	}
	
	public void deleteVehicle(String vehicleId) {
		repo.deleteById(vehicleId);
	}
	
	public List<Vehicle> getAllVehicles(){
		return repo.findAll();
	}
	
	/*public void updateVehicle(String vehicleId,Vehicle vehicle) {
		repo.save(vehicle);
	}*/

}
