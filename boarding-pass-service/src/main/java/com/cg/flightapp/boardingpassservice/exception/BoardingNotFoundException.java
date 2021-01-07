package com.cg.flightapp.boardingpassservice.exception;

public class BoardingNotFoundException extends Exception {
    public BoardingNotFoundException() {
    }

    public BoardingNotFoundException(String message) {
        super(message);
    }
}
