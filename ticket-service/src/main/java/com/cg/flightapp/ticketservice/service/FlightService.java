package com.cg.flightapp.ticketservice.service;

import com.cg.flightapp.ticketservice.model.Flight;
import org.springframework.http.ResponseEntity;

public interface FlightService {
    ResponseEntity<Flight> findFlightById(Integer flightId);
}
