package com.cg.flightapp.boardingpassservice.controller;

import com.cg.flightapp.boardingpassservice.exception.BoardingNotFoundException;
import com.cg.flightapp.boardingpassservice.model.Boarding;
import com.cg.flightapp.boardingpassservice.service.BoardingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boarding")
public class BoardingController {

    Logger logger = LoggerFactory.getLogger(BoardingController.class);

    private final BoardingService boardingService;

    public BoardingController(BoardingService boardingService) {
        this.boardingService = boardingService;
    }

    @DeleteMapping("/{id}")
    public void deleteBoardingById(@PathVariable("id") final Integer boardingId) {
        logger.info("Deleting boarding no. {}", boardingId);
        boardingService.deleteBoardingById(boardingId);
    }

    @GetMapping
    public List<Boarding> displayAllBoardings() {
        logger.info("Displaying all boardings");
        return boardingService.getAllBoardings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boarding> findBoardingById(@PathVariable("id") final Integer boardingId) {
        logger.info("Finding details of boarding no. {}", boardingId);
        Optional<Boarding> boarding = boardingService.findBoardingById(boardingId);
        return ResponseEntity.of(boarding);
    }

    @GetMapping("/checkedIn/{destinationId}/{baggageId}")
    public Boolean hasCheckedInByDestinationIdAndBaggageId(@PathVariable("destinationId") final Integer destinationId, @PathVariable("baggageId") final String baggageId) throws BoardingNotFoundException {
        logger.info("Is checked-in done for destination id {} and baggage id {}", destinationId, baggageId);
        return boardingService.hasCheckedInByDestinationIdAndBaggageId(destinationId, baggageId);
    }
}
