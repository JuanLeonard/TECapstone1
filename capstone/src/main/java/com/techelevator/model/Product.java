package com.techelevator.model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private double price;
    private String slotID;

    private String message;

    //Getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getSlotID() {
        return slotID;
    }
    public String getMessage() {
        return message;
    }

    //Constructor
    public Product(String name, double price, String slotID, String message){
        this.name = name;
        this.price = price;
        this.slotID = slotID;
        this.message = message;
    }

}
