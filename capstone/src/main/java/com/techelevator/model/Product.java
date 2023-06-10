package com.techelevator.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;

public class Product {
    private String name;
    private double price;
    private String slotID;

    private String message;

    private String item;

    //Getters
    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
    public Product(String name, double price, String slotID, String message) {
        this.name = name;
        this.price = price;
        this.slotID = slotID;
        this.message = message;
    }

//    public String[] productFile() {
//        Scanner userInput = new Scanner(System.in);
//        String filePath = "vendingmachine.csv";
//        File pathFile = new File(filePath);
//
////        try(Scanner scanner = new Scanner(pathFile) {
////            while (scanner.hasNextLine()){
//            String lineOfText = scanner.nextLine();
//            {
//                String[] productFile = lineOfText.split("\\|");
//                slotID = productFile[0];
//                name = productFile[1];
//                price = Double.parseDouble(productFile[2]);
//                item = productFile[3];
//            }
//
//
//            }
//        }
//
//    }
    }

