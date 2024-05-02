package com.bus.reservation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.reservation.model.Bus;
import com.bus.reservation.service.IBusService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {

	private final IBusService busService;
	
	@GetMapping
	public ResponseEntity<List<Bus>> getBus(){
		return new ResponseEntity<>(busService.getBus(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public Bus addBus(@RequestBody Bus bus) {
		return busService.addNewBus(bus);
	}
	
	@PutMapping("/update/{busId}")
	public Bus updateBus(@RequestBody Bus bus,@PathVariable Long busId) {
		return busService.updateBus(bus, busId);
	}
	
	@DeleteMapping("/delete/{busId}")
	public void deleteBus(@PathVariable Long busId) {
		busService.deleteBus(busId);
	}
	
	@GetMapping("/bus/{busId}")
	public Bus getBusById(@PathVariable Long busId) {
		return busService.getBusById(busId);
	}
	
}
