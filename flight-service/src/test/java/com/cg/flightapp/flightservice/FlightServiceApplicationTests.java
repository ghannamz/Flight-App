package com.cg.flightapp.flightservice;

import com.cg.flightapp.flightservice.model.Flight;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
class FlightServiceApplicationTests {

    @Mock
    private Flight flight;

    @Before
    public void setUp() {
    }

    @Test
    public void whenValidDepartureDate_thenFlightShouldBeFound() {
        String departureDate = "2017-11-15";
        Mockito.when(flight.getDepartureDate()).thenReturn(departureDate);
        assertEquals(departureDate, flight.getDepartureDate());
    }

}
