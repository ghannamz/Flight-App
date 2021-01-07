package com.cg.flightapp.passengerservice.service;

import com.cg.flightapp.passengerservice.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    void deletePassengerById(Integer passengerId);

    List<Passenger> getAllPassengers();

    Optional<Passenger> findPassengerById(Integer passengerId);
}
