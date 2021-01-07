package com.cg.flightapp.airplaneservice.repository;

import com.cg.flightapp.airplaneservice.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
}
