package com.techelevator;

import com.techelevator.model.VendingMachine;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run()  {
		Scanner userInput = new Scanner(System.in);
		String filePath = "mod-1-capstone-java-team-2\\capstone\\vendingmachine.csv";
		File file = new File (filePath);



		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			try(Scanner scanner = new Scanner(file)) {;
				while (scanner.hasNext())
					System.out.println(file);// display vending machine items
				}
			catch (FileNotFoundException e){
				System.out.println(e.getMessage());
			}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("Feed Money into the Vending Machine using Whole Dollars and type in the amount given");
				String userMoney = userInput.nextLine();

				try{
//					.getFedMoney = Integer.parseInt(userMoney);
				}catch(NumberFormatException e){
					System.out.println(e.getMessage());
				}


				System.out.println("Choose Slot Identifier");
				try(Scanner scanner = new Scanner(file)){
					String userChoice = userInput.nextLine();
					// do purchase
				}catch (FileNotFoundException e){
					System.out.println(e.getMessage());
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
