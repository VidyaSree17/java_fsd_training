package com.tcs.ReservationManagementSystem.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class User {
	
	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private String address;
	
	@Column(name="vehicleId")
	private String vehicleId;
	

}
