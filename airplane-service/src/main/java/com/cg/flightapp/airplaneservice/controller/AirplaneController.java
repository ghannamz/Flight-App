package com.cg.flightapp.airplaneservice.controller;

import com.cg.flightapp.airplaneservice.model.Airplane;
import com.cg.flightapp.airplaneservice.service.AirplaneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @DeleteMapping("/{id}")
    public void deleteAirplaneById(@PathVariable("id") final Integer airplaneId) {
        airplaneService.deleteAirplaneById(airplaneId);
    }

    @GetMapping
    public List<Airplane> displayAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airplane> findAirplaneById(@PathVariable("id") final Integer airplaneId) {
        Optional<Airplane> airplane = airplaneService.findAirplaneById(airplaneId);
        return ResponseEntity.of(airplane);
    }
}
