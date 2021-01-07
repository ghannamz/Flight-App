package com.cg.flightapp.passengerservice;

import com.cg.flightapp.passengerservice.model.Passenger;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
class PassengerServiceApplicationTests {

    @Mock
    private Passenger passenger;

    @Before
    public void setUp() {
    }

    @Test
    public void whenValidFirstName_thenPassengerShouldBeFound() {
        String firstName = "Adam";
        Mockito.when(passenger.getFirstName()).thenReturn(firstName);
        assertEquals(firstName, passenger.getFirstName());
    }
}
