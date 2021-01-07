package com.cg.flightapp.ticketservice.controller;

import com.cg.flightapp.ticketservice.exception.TicketNotFoundException;
import com.cg.flightapp.ticketservice.model.Coupon;
import com.cg.flightapp.ticketservice.model.Flight;
import com.cg.flightapp.ticketservice.model.Ticket;
import com.cg.flightapp.ticketservice.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    Logger logger = LoggerFactory.getLogger(TicketController.class);

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable("id") final Integer ticketId) {
        logger.info("Deleting ticket no. {}", ticketId);
        ticketService.deleteTicketById(ticketId);
    }

    @GetMapping
    public List<Ticket> displayAllTickets() {
        logger.info("Displaying all tickets");
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") final Integer ticketId) {
        logger.info("Getting details of ticket no. {}", ticketId);
        Optional<Ticket> ticket = ticketService.getTicketById(ticketId);
        return ResponseEntity.of(ticket);
    }

    @GetMapping("/isExist/{id}")
    public Boolean findTicketById(@PathVariable("id") final Integer ticketId) {
        logger.info("Checking if ticket no. {} exists", ticketId);
        return ticketService.findTicketById(ticketId);
    }

    @GetMapping("/coupon/{id}/{price}")
    public Coupon activateCoupon(@PathVariable("id") final Integer couponId, @PathVariable("price") final Double price) {
        logger.info("Trying to activate coupon no. {} on price {}", couponId, price);
        return ticketService.activateCoupon(couponId, price);
    }

    @GetMapping("/{id}/flight")
    public ResponseEntity<Flight> findFlightByTicketId(@PathVariable("id") final Integer ticketId) throws TicketNotFoundException {
        logger.info("Finding flight details of ticket no. {}", ticketId);
        return ticketService.findFlightByTicketId(ticketId);
    }
}
