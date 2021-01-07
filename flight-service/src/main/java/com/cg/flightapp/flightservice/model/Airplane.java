package com.cg.flightapp.flightservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Airplane {
    private Integer id;
    private String modelName;
    private String modelNumber;
}
