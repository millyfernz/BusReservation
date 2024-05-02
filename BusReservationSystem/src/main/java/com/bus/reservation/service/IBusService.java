package com.bus.reservation.service;

import java.util.List;

import com.bus.reservation.model.Bus;

public interface IBusService {
	Bus addNewBus(Bus bus);
	List<Bus> getBus();
	Bus updateBus(Bus bus, Long busId);
	Bus getBusById(Long busId);
	void deleteBus(Long busId);
}
