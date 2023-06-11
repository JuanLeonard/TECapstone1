package com.techelevator.model;

import java.math.BigDecimal;

public class Candy extends Product {

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
        return "Munch Munch, Yum!";
    }

    //Constructor from superclass
    public Candy(String name, double price, String slotID, String message){
        super(name, price, slotID, message);
    }


}
