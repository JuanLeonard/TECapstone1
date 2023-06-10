package com.techelevator.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory  {
    private Map<String, Product> productMap = new HashMap<>();

    public Map<String, Product> getProductMap() {
        return productMap;
    }


    public void getProductionMap() {
        String slotLocation = " ";
        String name;
        Double price = 0.00;
        String item;

        Scanner userInput = new Scanner(System.in);
        String filePath = "vendingmachine.csv";
        File pathFile = new File(filePath);

        try (Scanner scanner = new Scanner(pathFile)) {
            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine();
                String[] productFile = lineOfText.split("\\|");
                slotLocation = productFile[0];
                name = productFile[1];
                price = Double.parseDouble(productFile[2]);
                item = productFile[3];// display vending machine items


                if (item.equals("Chip")) {
                    Chips chips = new Chips(name, price, slotLocation, item);
                    productMap.put(slotLocation, chips);
                } else if (item.equals("Candy")) {
                    Candy candy = new Candy(name, price, slotLocation, item);
                    productMap.put(slotLocation, candy);
                } else if (item.equals("Drink")) {
                    Drinks drink = new Drinks(name, price, slotLocation, item);  //Change Classes to the right name
                    productMap.put(slotLocation, drink);
                } else if (item.equals("Gum")) {
                    Gum gum = new Gum(name, price, slotLocation, item);
                    productMap.put(slotLocation, gum);
                }
            }
        } catch (FileNotFoundException e) {

        }
    }

}
