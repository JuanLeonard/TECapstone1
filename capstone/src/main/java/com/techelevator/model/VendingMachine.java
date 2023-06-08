package com.techelevator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

   private double totalBalance;
   private double fedMoney;
   private double change;
   private List<Product> productList;

   //Getters
    public double getTotalBalance() {
        return totalBalance;
    }
    public double getFedMoney() {
        return fedMoney;
    }

    public double getChange() {
        return change;
    }

    //Constructor
    public VendingMachine(double totalBalance, double fedMoney){
        this.totalBalance = totalBalance;
        this.fedMoney = fedMoney;
        this.totalBalance = 0.00;
        this.fedMoney = 0.00;
        this.productList = new ArrayList<>();

    }

    //Setters

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }
    public void setFedMoney(double fedMoney) {
        this.fedMoney = fedMoney;
    }
    public void setChange(double change) {
        change = totalBalance - fedMoney;
        double totalCoins = 0;
//        double quarter = .25;
//        double dime = .10;
//        double nickel = .05;
//        double penny = .01;
        if(change % .25 == 0){
            totalCoins++;
        }
        if(change % .10 == 0){
            totalCoins++;
        }
        if(change % .05 == 0){
            totalCoins++;
        }
        if(change % .01 == 0){
            totalCoins++;
        }

    }

}
