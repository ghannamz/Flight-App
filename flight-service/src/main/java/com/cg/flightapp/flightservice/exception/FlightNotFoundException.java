package com.cg.flightapp.flightservice.exception;

public class FlightNotFoundException extends Exception {
    public FlightNotFoundException() {
    }

    public FlightNotFoundException(String message) {
        super(message);
    }
}
