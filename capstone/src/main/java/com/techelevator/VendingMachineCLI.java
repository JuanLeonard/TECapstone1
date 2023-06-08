package com.techelevator;

import com.techelevator.model.PurchaseProcessMenu;
import com.techelevator.model.VendingMachine;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.sql.SQLOutput;
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
	private PurchaseProcessMenu purchaseProcessMenu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public PurchaseProcessMenu getPurchaseProcessMenu() {
		return purchaseProcessMenu;
	}

	public void run()  {
		Scanner userInput = new Scanner(System.in);
		String filePath = "vendingmachine.csv";
		File pathFile = new File(filePath);




		while (true) {
//			System.out.println("Welcome to the Vendo-Matic 800.");
//			System.out.println("Powered by Umbrella Corp.");
//			System.out.println();
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			try(Scanner scanner = new Scanner(pathFile)) {
				while (scanner.hasNextLine()) {
					String lineOfText = scanner.nextLine();
					System.out.println(lineOfText);// display vending machine items
				}


			} catch (FileNotFoundException e){
				System.out.println(e.getMessage());
			}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				String purchaseChoice = (String) purchaseProcessMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
					System.out.println("Feed Money into the Vending Machine using Whole Dollars and type in the amount given");
					String userMoney = userInput.nextLine();
				}


				try {
//					.getFedMoney = Integer.parseInt(userMoney);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}



				System.out.println("Choose Slot Identifier");
				try(Scanner scanner = new Scanner(filePath)){
					String userChoice = userInput.nextLine();
					// do purchase
//				}catch (FileNotFoundException e){
//					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
