package com.cg.flightapp.ticketservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer passengerId;
    private Integer flightId;
    private Integer sourceId;
    private Integer destinationId;
    private Double price;
}
