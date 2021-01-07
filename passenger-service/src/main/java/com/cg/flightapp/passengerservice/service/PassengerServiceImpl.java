package com.cg.flightapp.passengerservice.service;

import com.cg.flightapp.passengerservice.model.Passenger;
import com.cg.flightapp.passengerservice.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public void deletePassengerById(Integer passengerId) {
        Optional<Passenger> passenger = findPassengerById(passengerId);
        passenger.ifPresent(passengerRepository::delete);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Optional<Passenger> findPassengerById(Integer passengerId) {
        return passengerRepository.findById(passengerId);
    }
}
