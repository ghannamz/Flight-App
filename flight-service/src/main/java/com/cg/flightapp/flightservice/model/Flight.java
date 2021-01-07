package com.cg.flightapp.flightservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private Integer sourceId;
    private Integer destinationId;
    private Integer planeId;
}
