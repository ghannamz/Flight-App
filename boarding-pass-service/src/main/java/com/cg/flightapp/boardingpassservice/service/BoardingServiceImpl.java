package com.cg.flightapp.boardingpassservice.service;

import com.cg.flightapp.boardingpassservice.exception.BoardingNotFoundException;
import com.cg.flightapp.boardingpassservice.model.Boarding;
import com.cg.flightapp.boardingpassservice.model.Ticket;
import com.cg.flightapp.boardingpassservice.repository.BoardingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardingServiceImpl implements BoardingService {

    private final BoardingRepository boardingRepository;
    private final TicketService ticketService;

    public BoardingServiceImpl(BoardingRepository boardingRepository, TicketService ticketService) {
        this.boardingRepository = boardingRepository;
        this.ticketService = ticketService;
    }

    @Override
    public void deleteBoardingById(Integer boardingId) {
        Optional<Boarding> boarding = findBoardingById(boardingId);
        boarding.ifPresent(boardingRepository::delete);
    }

    @Override
    public List<Boarding> getAllBoardings() {
        return boardingRepository.findAll();
    }

    @Override
    public Optional<Boarding> findBoardingById(Integer boardingId) {
        return boardingRepository.findById(boardingId);
    }

    @Override
    public Boolean hasCheckedInByDestinationIdAndBaggageId(Integer destinationId, String baggageId) throws BoardingNotFoundException {
        Optional<Boarding> optionalBoarding = boardingRepository.findBoardingByBaggageId(baggageId);
        Boarding boarding = optionalBoarding.orElseThrow(() -> new BoardingNotFoundException("Boarding details with baggage id = " + baggageId + " does not exist."));
        ResponseEntity<Ticket> ticket = ticketService.findTicketById(boarding.getTicketId());
        if (ticket != null && ticket.getBody() != null && ticket.getBody().getDestinationId().equals(destinationId)) {
            return boarding.getHasCheckedIn();
        }
        return false;
    }
}
