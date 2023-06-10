package com.techelevator.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private int totalBalance; //This will be the sum of all vending items the user selects.
    private int moneyProvided; //This will be the money the user feeds into the machine.
    private int change; //Remaining money from user's transactions.
    private Map<String, Double> productList = new HashMap<>();

    //Getters
    public int getTotalBalance() {
        return totalBalance;
    }

    public int getMoneyProvided() {
        return moneyProvided;
    }

    public double getChange() {
        return change;
    }

    //Constructor
    public VendingMachine(int totalBalance, int moneyProvided) {
        this.totalBalance = totalBalance;
        this.moneyProvided = 0;
        this.change = 0;
        this.productList = new HashMap<>();

    }

    //Setters

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    public void setMoneyProvided(int moneyProvided) {
        if (moneyProvided > 2000){
            throw new IllegalArgumentException();
        }
        System.out.println("You've reached the limit. Time to pick an item!");
    }

    public void setChange(int change) {
        change = moneyProvided - totalBalance;
        int totalCoins = 0;
        int quarter = 25;
        int dime = 10;
        int nickel = 5;

        quarter = change / 25;
        change = change % 25;
        dime = change / 10;
        change = change % 10;
        nickel = change / 5;
        change = change % 5;

        int changeBack = quarter + dime + nickel;


    }

}

//    HashMap<String, String> productMap = new HashMap<>();
//    String filePath = "vendingmachine.csv";
//    File pathFile = new File(filePath);

//        try {Scanner scanner = new Scanner(pathFile).useDelimiter("|");
//            System.out.println();
//            while (scanner.hasNextLine()) {
//                String slotLocation;
//                String name;
//                String price;
//                String item;
//
//                String lineOfText = scanner.nextLine();
//                slotLocation = scanner.next();
//                name = scanner.next();
//                price = scanner.next();
//                item = scanner.next();// display vending machine items
//                productMap.put(slotLocation, price);
//
//                System.out.println(productMap.get(slotLocation) + productMap.get(price));
//            }
//
//        }
//
//    }
