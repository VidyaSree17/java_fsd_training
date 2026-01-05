package com.tcs.ReservationManagementSystem.bean;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

	@Id
	@Length(min=5,max=10,message="Please provide valid vehicle id")
	private String vehicleId;
	
	@Column
	@Length(min=5,max=20,message="Please provide valid vehicle model")
	private String vehicleModel;
	
	@Column
	@Positive(message="Please provide positive values")
	@Max(value=10000,message="Please provide valuesless than 10k")
	private int seatPerCost;
	
	@Column
	@Length(min=10,message="Please provide valid ownername")
	private String ownerName;
	
	@Column
	@Length(min=10,max=15,message="Please provide valid phone number")
	private String phonenumber;
	
	@OneToMany
	@JoinColumn(name="vehicleId")
	List<User> user;
}
