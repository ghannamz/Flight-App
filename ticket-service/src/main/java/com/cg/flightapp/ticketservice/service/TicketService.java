package com.cg.flightapp.ticketservice.service;

import com.cg.flightapp.ticketservice.exception.TicketNotFoundException;
import com.cg.flightapp.ticketservice.model.Coupon;
import com.cg.flightapp.ticketservice.model.Flight;
import com.cg.flightapp.ticketservice.model.Ticket;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    void deleteTicketById(Integer ticketId);

    List<Ticket> getAllTickets();

    Boolean findTicketById(Integer ticketId);

    Optional<Ticket> getTicketById(Integer ticketId);

    Coupon activateCoupon(Integer couponId, Double price);

    ResponseEntity<Flight> findFlightByTicketId(Integer ticketId) throws TicketNotFoundException;
}
