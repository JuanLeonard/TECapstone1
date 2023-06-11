package com.techelevator.model;

import java.math.BigDecimal;

public class Chips extends Product{

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSlotID() {
        return super.getSlotID();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
    @Override
    public String getMessage() {
        return "Crunch Crunch, Yum!";
    }

    //Constructor from superclass
    public Chips(String name, double price, String slotID, String message){
        super(name, price, slotID, message);
    }






}
