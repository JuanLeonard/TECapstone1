package org.example;

import java.util.HashMap;
import java.util.Map;

public class Products {
//1710452500
//    public Map<String, Double> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(Map<String, Double> productList) {
//        this.productList = productList;
//    }

    public static String totalBalance(String userSelection){
        Map<String, Double> productList = new HashMap<>();

        double sumOfVending = 0.00;
        String balance = "Total Balance: " + sumOfVending;

        productList.put("A1", 3.05);
        productList.put("A2", 1.45);
        productList.put("A3", 2.75);
        productList.put("A4", 3.65);
        productList.put("B1", 1.80);
        productList.put("B2", 1.50);
        productList.put("B3", 1.50);
        productList.put("B4", 1.75);
        productList.put("C1", 1.25);
        productList.put("C2", 1.50);
        productList.put("C3", 1.50);
        productList.put("C4", 1.50);
        productList.put("D1", 0.85);
        productList.put("D2", 0.95);
        productList.put("D3", 0.75);
        productList.put("D4", 0.75);

        sumOfVending += productList.get(userSelection);
        return balance;
    }
}
