package com.cg.flightapp.flightservice.service;

import com.cg.flightapp.flightservice.exception.FlightNotFoundException;
import com.cg.flightapp.flightservice.model.Airplane;
import com.cg.flightapp.flightservice.model.Flight;
import com.cg.flightapp.flightservice.repository.FlightRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final AirplaneService airplaneService;

    public FlightServiceImpl(FlightRepository flightRepository, AirplaneService airplaneService) {
        this.flightRepository = flightRepository;
        this.airplaneService = airplaneService;
    }

    @Override
    public void deleteFlightById(Integer flightId) {
        Optional<Flight> flight = findFlightById(flightId);
        flight.ifPresent(flightRepository::delete);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findFlightById(Integer flightId) {
        return flightRepository.findById(flightId);
    }

    @Override
    public ResponseEntity<Airplane> findPlaneByFlightId(Integer flightId) throws FlightNotFoundException {
        Optional<Flight> optionalFlight = findFlightById(flightId);
        Flight flight = optionalFlight.orElseThrow(() -> new FlightNotFoundException("Flight no. " + flightId + " does not exists."));
        return airplaneService.findAirplaneById(flight.getPlaneId());
    }
}
