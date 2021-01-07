package com.cg.flightapp.airplaneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.cg.flightapp.airplaneservice.repository")
@EntityScan(basePackages = "com.cg.flightapp.airplaneservice.model")
@SpringBootApplication
public class AirplaneServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirplaneServiceApplication.class, args);
    }

}
