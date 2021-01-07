package com.cg.flightapp.ticketservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passenger {
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
}
