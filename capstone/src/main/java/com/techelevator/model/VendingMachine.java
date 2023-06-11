package com.techelevator.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private double itemTotal; //This will be the sum of all vending items the user selects.
    private double vendingBalance; //This will be the sum of the user's monetary input into the machine.
    private int moneyProvided; //This will be the money the user feeds into the machine.
    private double change; //Remaining money from user's transactions.
    //private Map<String, Double> productList = new TreeMap<>();
    private Inventory inventoryMap = new Inventory();

    //Getters
    public double getItemTotal() {
        return itemTotal;
    }

    public int getMoneyProvided() {
        return moneyProvided;
    }

    public double getChange() {
        change = vendingBalance - itemTotal;
        return change;
    }

    public double getVendingBalance() {
        return vendingBalance;
    }

    public void setVendingBalance(double vendingBalance) {
        this.vendingBalance = vendingBalance;
    }

    public Inventory getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Inventory inventoryMap) {
        this.inventoryMap = inventoryMap;
    }


    //Constructor
    public VendingMachine(int itemTotal, int vendingBalance) {
        this.itemTotal = itemTotal;
        this.vendingBalance = vendingBalance;
        this.moneyProvided = 0;
        this.change = 0;
        //this.productList = new HashMap<>();

    }

    //Setters
    public void setItemTotal(int itemTotal) {
        itemTotal = itemTotal;

    }

    public void setMoneyProvided(int moneyProvided) {
        if (moneyProvided > 2000){
            throw new IllegalArgumentException("You've reached the limit. Time to pick an item!");
        }

    }


    public void addMoney(int moneyProvided){
        vendingBalance += moneyProvided;
    }
    public void addItemSum(int itemSum){
        itemTotal += itemSum;
    }

    public void setChange(double change) {
//        change = vendingBalance - itemTotal;
        int totalCoins = 0;
        double quarter = .25;
        double dime = .10;
        double nickel = .05;

        quarter = change / .25;
        change = change % .25;
        int convQuarter = (int) quarter;
        dime = change / .10;
        change = change % .10;
        int convDime = (int) dime;
        nickel = change / .05;
        change = change % .05;
        int convNickel = (int) nickel;

        double changeBack = quarter + dime + nickel;

        System.out.println("Quarters: " + convQuarter);
        System.out.println("Dimes: " + convDime);
        System.out.println("Nickels: " + convNickel);
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
