package com.cg.flightapp.ticketservice.service;

import com.cg.flightapp.ticketservice.model.Flight;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightServiceImpl implements FlightService {

    private final String flightService;
    private final String flightServiceApiPath;
    private final RestTemplate restTemplate;

    public FlightServiceImpl(@Value("${flight.service}") String flightService,
                             @Value("${flight.path}") String flightServiceApiPath,
                             RestTemplate restTemplate) {
        this.flightService = flightService;
        this.flightServiceApiPath = flightServiceApiPath;
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(commandKey = "flight-by-id", groupKey = "ticket-service", fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "800"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
    })
    @Override
    public ResponseEntity<Flight> findFlightById(Integer flightId) {
        return restTemplate.getForEntity(flightService + flightServiceApiPath + flightId, Flight.class);
    }

    public ResponseEntity<Flight> fallback(Integer flightId) {
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
