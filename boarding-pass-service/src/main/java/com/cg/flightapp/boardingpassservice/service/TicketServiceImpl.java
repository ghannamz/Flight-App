package com.cg.flightapp.boardingpassservice.service;

import com.cg.flightapp.boardingpassservice.model.Ticket;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketServiceImpl implements TicketService {

    private final String ticketService;
    private final String ticketServiceApiPath;
    private final RestTemplate restTemplate;

    public TicketServiceImpl(@Value("${ticket.service}") String ticketService,
                             @Value("${ticket.path}") String ticketServiceApiPath,
                             RestTemplate restTemplate) {
        this.ticketService = ticketService;
        this.ticketServiceApiPath = ticketServiceApiPath;
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(commandKey = "ticket-by-id", groupKey = "boarding-pass-service", fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "800"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
    })
    @Override
    public ResponseEntity<Ticket> findTicketById(Integer ticketId) {
        return restTemplate.getForEntity(ticketService + ticketServiceApiPath + ticketId, Ticket.class);
    }

    public ResponseEntity<Ticket> fallback(Integer ticketId) {
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
