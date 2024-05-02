package com.bus.reservation.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long busId;
	private String busName;
	private String busType;
	private Integer seatCount;
	private Integer seatAvailable;
	@NaturalId(mutable = true)
	private String busNumber;
	private Long routeId;
	private String date;
	

}
