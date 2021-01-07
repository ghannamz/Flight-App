package com.cg.flightapp.passengerservice.controller;

import com.cg.flightapp.passengerservice.model.Passenger;
import com.cg.flightapp.passengerservice.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @DeleteMapping("/{id}")
    public void deletePassengerById(@PathVariable("id") final Integer passengerId) {
        passengerService.deletePassengerById(passengerId);
    }

    @GetMapping
    public List<Passenger> displayAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> findPassengerById(@PathVariable("id") final Integer passengerId) {
        Optional<Passenger> passenger = passengerService.findPassengerById(passengerId);
        return ResponseEntity.of(passenger);
    }
}
