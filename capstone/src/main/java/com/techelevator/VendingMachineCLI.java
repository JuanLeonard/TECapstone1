package com.techelevator;

//import com.techelevator.model.PurchaseProcessMenu;

import com.techelevator.model.*;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        Scanner userInput = new Scanner(System.in);
        String filePath = "vendingmachine.csv";
        File pathFile = new File(filePath);

        System.out.println("Welcome to the Vendo-Matic 800.");
        System.out.println("Powered by Umbrella Corp.");
        System.out.println();

        Inventory currentInventory = new Inventory();//Created an instance of inventory to use later
        VendingMachine vendingMachine = new VendingMachine(0, 0);//Initializes the vending machine balances
        Map<String, Product> productList = new TreeMap<>();//Created an instance of the product map to be used later
        vendingMachine.setInventoryMap(currentInventory);//Initializes the inventory before app start-up
        productList = vendingMachine.getInventoryMap().getProductMap();//Variable allows us to call the inventory in the code

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            //Option 1) Display Vending Machine Items
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                try (Scanner scanner = new Scanner(pathFile)) {
                    System.out.println();
                    while (scanner.hasNextLine()) {
                        String lineOfText = scanner.nextLine();
                        System.out.println(lineOfText);// display vending machine items
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }

                //Option 2) Purchase
            } while (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

                double currentMoneyProvided = vendingMachine.getVendingBalance();

                System.out.println();
                System.out.print("Current Money Provided: $" + String.format("%.2f",currentMoneyProvided));
                System.out.println();
                String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);


                if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                    System.out.println();
                    try {
                        System.out.print("Feed money into vending machine using whole numbers (Ex. 1 = $1.00): ");
                        String userMoney = userInput.nextLine();
                        if (userMoney.contains(".")) {
                        }
                        Double convertedMoney = Double.parseDouble(userMoney);//Converts String into integer
//                        if (convertedMoney > 20) {
//                            System.out.println("ERROR: Exceeds max amount. Enter an amount less than $20.");
//                        }
                        vendingMachine.addMoney(convertedMoney);//Adds money to the balance
                        System.out.println();
                        VMLog.log("FEED MONEY: $" + String.format("%.2f",convertedMoney) + " $" + String.format("%.2f",currentMoneyProvided + convertedMoney));
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: WRONG NUMBER FORMAT. Use whole numbers (1 = $1.00)");
                    }

                }

                if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                    try (Scanner scanner = new Scanner(pathFile)) {
                        System.out.println();
                        while (scanner.hasNextLine()) {
                            String lineOfText = scanner.nextLine();
                            System.out.println(lineOfText);// display vending machine items
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                        System.out.println();
                        System.out.print("Please enter slot location using Capital Letters (Ex. A1): ");
                        String userProductChoice = userInput.nextLine();
                        if(!productList.containsKey(userProductChoice)) {
                            System.out.println("ERROR: CODE INVALID");
                        } else {
                            Product product = productList.get(userProductChoice);//Create a product class instance that use's the user's input to retrieve item info.
                            double itemPrice = product.getPrice();
                            if(vendingMachine.sufficientFunds(itemPrice)) {
                                System.out.println();
                                System.out.println(product.getName());
                                System.out.println("$" + String.format("%.2f", product.getPrice()));
                                System.out.println(product.getMessage());
                                System.out.println();
                                double runningTotal = currentMoneyProvided - itemPrice;
                                vendingMachine.setVendingBalance(runningTotal);
                                VMLog.log(product.getName() + " " + userProductChoice + " $" + String.format("%.2f", product.getPrice()) + " $" + String.format("%.2f", runningTotal));
                                System.out.println("Would you like anything else?");
                            } else {
                                System.out.println("ERROR: INSUFFICIENT FUNDS");
                            }

                        }

                    }
                if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
                    System.out.println();
                    System.out.print("Thanks! Here's your change: $");
                    System.out.printf("%.2f%n",vendingMachine.getChange());
                    vendingMachine.setChange(currentMoneyProvided);
                    vendingMachine.setVendingBalance(0.0);
                    System.out.println();
                    VMLog.log("GIVE CHANGE: $" + String.format("%.2f",currentMoneyProvided) + " $" + String.format("%.2f",vendingMachine.getChange()));
                    break;
                }

                }
            if (choice.equals(MAIN_MENU_OPTION_EXIT)){
                System.out.println();
                System.out.println("Thanks for using the Vendo-Matic 800.");
                System.out.println("Have a good day!");
                break;
            }
            }
        }

//
        public static void main (String[]args){
            Menu menu = new Menu(System.in, System.out);
            VendingMachineCLI cli = new VendingMachineCLI(menu);
            cli.run();
        }
    }

//    else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
//            System.out.println();
//            System.out.println("Thank you,have a great day! :)");
//            false;






