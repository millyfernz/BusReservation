package com.bus.reservation.exception;

public class BusAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 9084821603101105321L;

	public BusAlreadyExistsException(String message) {
		super(message);
	}

}
