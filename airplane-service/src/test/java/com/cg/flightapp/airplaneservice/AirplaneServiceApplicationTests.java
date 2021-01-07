package com.cg.flightapp.airplaneservice;

import com.cg.flightapp.airplaneservice.model.Airplane;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
class AirplaneServiceApplicationTests {

    @Mock
    private Airplane airplane;

    @Before
    public void setUp() {
    }

    @Test
    public void whenValidManufacturer_thenAirplaneShouldBeFound() {
        String manufacturer = "British Airways";
        Mockito.when(airplane.getManufacturer()).thenReturn(manufacturer);
        assertEquals(manufacturer, airplane.getManufacturer());
    }

}
