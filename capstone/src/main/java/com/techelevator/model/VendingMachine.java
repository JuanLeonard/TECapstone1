package com.techelevator.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private int totalBalance;
    private int fedMoney;
    private int change;
    private Map<String, Double> productList = new HashMap<>();

    //Getters
    public int getTotalBalance() {
        return totalBalance;
    }

    public int getFedMoney() {
        return fedMoney;
    }

    public double getChange() {
        return change;
    }

    //Constructor
    public VendingMachine(int totalBalance, int fedMoney) {
        this.totalBalance = totalBalance;
        this.fedMoney = fedMoney;
        this.totalBalance = 0;
        this.fedMoney = 0;
        this.productList = new HashMap<>();

    }

    //Setters

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    public void setFedMoney(int fedMoney) {
        this.fedMoney = fedMoney;
    }

    public void setChange(int change) {
        change = totalBalance - fedMoney;
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
