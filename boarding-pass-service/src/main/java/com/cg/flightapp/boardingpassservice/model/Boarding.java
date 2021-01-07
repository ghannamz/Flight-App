package com.cg.flightapp.boardingpassservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Boarding")
public class Boarding {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer flightId;
    private Integer passengerId;
    private Integer ticketId;
    private String gate;
    private String baggageId;
    private Boolean hasCheckedIn;
}
