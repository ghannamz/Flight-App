package com.cg.flightapp.flightservice.controller;

import com.cg.flightapp.flightservice.exception.FlightNotFoundException;
import com.cg.flightapp.flightservice.model.Airplane;
import com.cg.flightapp.flightservice.model.Flight;
import com.cg.flightapp.flightservice.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @DeleteMapping("/{id}")
    public void deleteFlightById(@PathVariable("id") final Integer flightId) {
        flightService.deleteFlightById(flightId);
    }

    @GetMapping
    public List<Flight> displayAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findFlightById(@PathVariable("id") final Integer flightId) {
        Optional<Flight> flight = flightService.findFlightById(flightId);
        return ResponseEntity.of(flight);
    }

    @GetMapping("/{id}/plane")
    public ResponseEntity<Airplane> findPlaneByFlightId(@PathVariable("id") final Integer flightId) throws FlightNotFoundException {
        return flightService.findPlaneByFlightId(flightId);
    }
}
