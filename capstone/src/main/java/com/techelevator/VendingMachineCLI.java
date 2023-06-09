package com.techelevator;

//import com.techelevator.model.PurchaseProcessMenu;

import com.techelevator.model.VendingMachine;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

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
                double currentMoneyProvided = 0.00;
                VendingMachine money = new VendingMachine(0, 5);

                System.out.println();
                System.out.print("Current Money Provided: $");
                System.out.printf("%.2f%n", currentMoneyProvided);
                String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                    System.out.println();
                    try {
                        System.out.print("Feed money into vending machine using penny math. Ex. $1.00 = 100 (Max amount $20): ");
                        String userMoney = userInput.nextLine();
                        if (userMoney.contains(".")) {
                            //System.out.println("ERROR: Wrong number format. Use penny math ($1.00 = 100)");
                        }
                        Integer fedMoney = Integer.parseInt(userMoney);
                        if (currentMoneyProvided > 2000) {
                            System.out.println("ERROR: Exceeds max amount. Enter an amount less than $20.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Wrong number format. Use penny math ($1.00 = 100)");
                    }
//                    double wholeNum = Double.parseDouble(userInput.nextLine());
//                    currentMoneyProvided += wholeNum;
                }

                if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                    System.out.println();

                    //Empty Map
                    HashMap<String, String> productMap = new HashMap<>();
                    String slotLocation;
                    String name;
                    String price;
                    String item;

                    Scanner scanner = null;
                    try {
                        scanner = new Scanner(pathFile).useDelimiter("|");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println();

                            String lineOfText = scanner.nextLine();
                            slotLocation = scanner.next();
                            name = scanner.next();
                            price = scanner.next();
                            item = scanner.next();// display vending machine items
                            String productDisplay = productMap.put(slotLocation, price);


                    System.out.println(productMap.get(slotLocation) + productMap.get(price));
                        System.out.println();


                            System.out.println("Please enter slot location using Capital Letters example: A1");
                            String userProductChoice = userInput.nextLine();

                            if (!userProductChoice.equals(productMap)) {

                            }


                    }
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






