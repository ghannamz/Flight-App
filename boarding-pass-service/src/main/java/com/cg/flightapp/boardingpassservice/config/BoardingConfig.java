package com.cg.flightapp.boardingpassservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BoardingConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
