package com.cg.flightapp.flightservice.service;

import com.cg.flightapp.flightservice.model.Airplane;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final String planeService;
    private final String planeServiceApiPath;
    private final RestTemplate restTemplate;

    public AirplaneServiceImpl(@Value("${plane.service}") String planeService,
                               @Value("${plane.path}") String planeServiceApiPath,
                               RestTemplate restTemplate) {
        this.planeService = planeService;
        this.planeServiceApiPath = planeServiceApiPath;
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(commandKey = "airplane-by-id", groupKey = "flight-service", fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "800"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
    })
    @Override
    public ResponseEntity<Airplane> findAirplaneById(Integer airplaneId) {
        return restTemplate.getForEntity(planeService + planeServiceApiPath + airplaneId, Airplane.class);
    }

    public ResponseEntity<Airplane> fallback(Integer airplaneId) {
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
