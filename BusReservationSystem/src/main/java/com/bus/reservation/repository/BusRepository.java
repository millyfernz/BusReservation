package com.bus.reservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.reservation.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Long>{

	Optional<Bus> findByBusNumber(String busNumber);

}
