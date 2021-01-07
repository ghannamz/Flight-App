package com.cg.flightapp.airplaneservice.service;

import com.cg.flightapp.airplaneservice.model.Airplane;
import com.cg.flightapp.airplaneservice.repository.AirplaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public void deleteAirplaneById(Integer airplaneId) {
        Optional<Airplane> airplane = findAirplaneById(airplaneId);
        airplane.ifPresent(airplaneRepository::delete);
    }

    @Override
    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @Override
    public Optional<Airplane> findAirplaneById(Integer airplaneId) {
        return airplaneRepository.findById(airplaneId);
    }
}
