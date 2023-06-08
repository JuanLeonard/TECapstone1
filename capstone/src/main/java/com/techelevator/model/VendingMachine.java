package com.techelevator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

   private int totalBalance;
   private int fedMoney;
   private int change;
   private List<Product> productList;

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
    public VendingMachine(int totalBalance, int fedMoney){
        this.totalBalance = totalBalance;
        this.fedMoney = fedMoney;
        this.totalBalance = 0;
        this.fedMoney =  0;
        this.productList = new ArrayList<>();

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
