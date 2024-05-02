package com.bus.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bus.reservation.exception.BusAlreadyExistsException;
import com.bus.reservation.exception.BusNotFoundException;
import com.bus.reservation.model.Bus;
import com.bus.reservation.repository.BusRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusService implements IBusService {

	private final BusRepository busRepository;

	@Override
	public Bus addNewBus(Bus bus){
		if (busAlreadyExists(bus.getBusNumber())) {
			throw new BusAlreadyExistsException(bus.getBusNumber() + " already exists!");
		}
		return busRepository.save(bus);
	}

	@Override
	public List<Bus> getBus() {
		return busRepository.findAll();
	}

	@Override
	public Bus updateBus(Bus bus, Long busId) {
		
		return busRepository.findById(busId).map(b -> {
			b.setBusName(bus.getBusName());
			b.setBusNumber(bus.getBusNumber());
			b.setBusType(bus.getBusType());
			b.setSeatAvailable(bus.getSeatAvailable());
			b.setSeatCount(bus.getSeatCount());
			b.setDate(bus.getDate());
			return busRepository.save(b);
			
		}).orElseThrow(() -> new BusNotFoundException("Sorry! This bus could not be found"));
	}

	@Override
	public Bus getBusById(Long busId) {
		return busRepository.findById(busId)
				.orElseThrow(()->new BusNotFoundException("Sorry,bus could not be found  with id: "+busId));
	}

	@Override
	public void deleteBus(Long busId) {
		if(!busRepository.existsById(busId)) {
			throw new BusNotFoundException("Sorry, bus not found");
		}

		busRepository.deleteById(busId);
	}

	private boolean busAlreadyExists(String busNumber) {
		return busRepository.findByBusNumber(busNumber).isPresent();
	}

}
