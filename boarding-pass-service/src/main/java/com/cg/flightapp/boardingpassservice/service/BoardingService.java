package com.cg.flightapp.boardingpassservice.service;

import com.cg.flightapp.boardingpassservice.exception.BoardingNotFoundException;
import com.cg.flightapp.boardingpassservice.model.Boarding;

import java.util.List;
import java.util.Optional;

public interface BoardingService {
    void deleteBoardingById(Integer boardingId);

    List<Boarding> getAllBoardings();

    Optional<Boarding> findBoardingById(Integer boardingId);

    Boolean hasCheckedInByDestinationIdAndBaggageId(Integer destinationId, String baggageId) throws BoardingNotFoundException;
}
