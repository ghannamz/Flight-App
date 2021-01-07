package com.cg.flightapp.ticketservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flight {
    private Integer id;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private Integer sourceId;
    private Integer destinationId;
    private Integer planeId;
}
