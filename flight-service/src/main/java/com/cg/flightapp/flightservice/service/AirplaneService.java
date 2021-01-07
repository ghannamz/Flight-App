package com.cg.flightapp.flightservice.service;

import com.cg.flightapp.flightservice.model.Airplane;
import org.springframework.http.ResponseEntity;

public interface AirplaneService {
    ResponseEntity<Airplane> findAirplaneById(Integer airplaneId);
}
