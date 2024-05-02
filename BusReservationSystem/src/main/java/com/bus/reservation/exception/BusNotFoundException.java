package com.bus.reservation.exception;

public class BusNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 7629554106913541484L;

	public BusNotFoundException(String message) {
		super(message);
	}

}
