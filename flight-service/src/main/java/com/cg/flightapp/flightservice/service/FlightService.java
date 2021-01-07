package com.cg.flightapp.flightservice.service;

import com.cg.flightapp.flightservice.exception.FlightNotFoundException;
import com.cg.flightapp.flightservice.model.Airplane;
import com.cg.flightapp.flightservice.model.Flight;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    void deleteFlightById(Integer flightId);

    List<Flight> getAllFlights();

    Optional<Flight> findFlightById(Integer flightId);

    ResponseEntity<Airplane> findPlaneByFlightId(Integer flightId) throws FlightNotFoundException;
}
