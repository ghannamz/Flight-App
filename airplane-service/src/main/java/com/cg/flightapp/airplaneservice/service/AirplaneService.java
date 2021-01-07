package com.cg.flightapp.airplaneservice.service;

import com.cg.flightapp.airplaneservice.model.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {
    void deleteAirplaneById(Integer airplaneId);

    List<Airplane> getAllAirplanes();

    Optional<Airplane> findAirplaneById(Integer airplaneId);
}
