package com.tcs.ReservationManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ReservationManagementSystem.bean.Vehicle;
import com.tcs.ReservationManagementSystem.service.VehicleService;

import jakarta.validation.Valid;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService service;
	
	@PostMapping("/savevehicle")
	public ResponseEntity<String> saveVehicleDetails(@Valid @RequestBody Vehicle vehicle) {
		service.saveVehicle(vehicle);
		return new ResponseEntity<>("Vehicle Data have been saved Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getvehiclebyid/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable String vehicleId){
		Vehicle vehicle=service.getVehicle(vehicleId);
		return new ResponseEntity<>(vehicle,HttpStatus.OK);
	}
	
	@GetMapping("/getbyownername/{ownerName}")
	public ResponseEntity<List<Vehicle>> getVehicleByOwner(@PathVariable String ownerName){
		List<Vehicle> list = service.findVehicleByOwner(ownerName);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletevehicle/{vehicleId}")
	public ResponseEntity<String> deleteVehicleById(@PathVariable String vehicleId){
		service.deleteVehicle(vehicleId);
		return new ResponseEntity<>("Vehicle Data have been deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getallvehicles")
	public ResponseEntity<List<Vehicle>> getAll(){
		List<Vehicle> list=service.getAllVehicles();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	/*@PutMapping("/updatevehicle/{vehicleId}")
	public ResponseEntity<String> UpdateVehicleByid(@PathVariable String vehicleId,@RequestBody Vehicle vehicle) {
		service.updateVehicle(vehicleId, vehicle);
		return new ResponseEntity<>("Vehicle Data have been updated successfully",HttpStatus.OK);
	}*/
}
