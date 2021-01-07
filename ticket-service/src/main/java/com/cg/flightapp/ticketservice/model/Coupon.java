package com.cg.flightapp.ticketservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
public class Coupon {
    private Integer id;
    @JsonIgnore
    private Double discount;
    private boolean valid;
    private Double price;

    public Coupon(Integer id, Double price) {
        this.id = id;
        this.price = price;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    private void updateDiscount() {
        List<Double> availableDiscounts = Arrays.asList(0.1, 0.5, 0.6);
        Random rand = new Random();
        discount = availableDiscounts.get(rand.nextInt(availableDiscounts.size()));
    }

    public void updateFinalPrice() {
        updateDiscount();
        this.price -= price * discount;
    }
}
