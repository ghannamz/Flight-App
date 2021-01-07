package com.cg.flightapp.airplaneservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Airplane")
public class Airplane {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String modelName;
    private String modelNumber;
    private Integer capacity;
    private String manufacturer;
}
