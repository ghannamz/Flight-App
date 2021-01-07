package com.cg.flightapp.boardingpassservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {
    private Integer id;
    private Integer passengerId;
    private Integer flightId;
    private Integer sourceId;
    private Integer destinationId;
    private Double price;
}
