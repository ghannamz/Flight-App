package com.cg.flightapp.boardingpassservice.repository;

import com.cg.flightapp.boardingpassservice.model.Boarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardingRepository extends JpaRepository<Boarding, Integer> {

    @Query("SELECT b FROM Boarding b WHERE b.baggageId = :baggageId")
    Optional<Boarding> findBoardingByBaggageId(@Param("baggageId") final String baggageId);
}
