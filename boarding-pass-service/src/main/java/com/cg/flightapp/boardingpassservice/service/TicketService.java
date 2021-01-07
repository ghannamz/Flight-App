package com.cg.flightapp.boardingpassservice.service;

import com.cg.flightapp.boardingpassservice.model.Ticket;
import org.springframework.http.ResponseEntity;

public interface TicketService {
    ResponseEntity<Ticket> findTicketById(Integer ticketId);
}
