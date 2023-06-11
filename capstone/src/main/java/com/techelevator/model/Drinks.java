package com.techelevator.model;

import java.math.BigDecimal;

public class Drinks extends Product{

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
        return "Glug Glug, Yum!";
    }

    //Constructor from superclass
    public Drinks(String name, double price, String slotID, String message){
        super(name, price, slotID, message);
    }
}
