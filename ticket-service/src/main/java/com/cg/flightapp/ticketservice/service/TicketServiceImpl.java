package com.cg.flightapp.ticketservice.service;

import com.cg.flightapp.ticketservice.cache.Cache;
import com.cg.flightapp.ticketservice.exception.TicketNotFoundException;
import com.cg.flightapp.ticketservice.model.Coupon;
import com.cg.flightapp.ticketservice.model.Flight;
import com.cg.flightapp.ticketservice.model.Ticket;
import com.cg.flightapp.ticketservice.repository.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private List<Integer> validCouponIds;

    public TicketServiceImpl(TicketRepository ticketRepository, FlightService flightService) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
        generateValidCouponIds();
    }

    private void generateValidCouponIds() {
        validCouponIds = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            validCouponIds.add(random.nextInt(20));
        }
        System.out.println("The valid coupon ids are:");
        validCouponIds.forEach(System.out::println);
    }

    @Override
    public void deleteTicketById(Integer ticketId) {
        Optional<Ticket> ticket = getTicketById(ticketId);
        ticket.ifPresent(ticketRepository::delete);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> getTicketById(Integer ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    public Coupon activateCoupon(Integer couponId, Double price) {
        Coupon coupon = new Coupon(couponId, price);
        if (validCouponIds.contains(couponId)) {
            coupon.setValid(true);
            coupon.updateFinalPrice();
        } else {
            coupon.setValid(false);
        }
        return coupon;
    }

    @Override
    public Boolean findTicketById(Integer ticketId) {
        return getTicketById(ticketId).isPresent();
    }

    @Override
    public ResponseEntity<Flight> findFlightByTicketId(Integer ticketId) throws TicketNotFoundException {
        Optional<Ticket> optionalTicket = getTicketById(ticketId);
        Ticket ticket = optionalTicket.orElseThrow(() -> new TicketNotFoundException("Ticket no. " + ticketId + " does not exists."));
        return flightService.findFlightById(ticket.getFlightId());
    }
}
