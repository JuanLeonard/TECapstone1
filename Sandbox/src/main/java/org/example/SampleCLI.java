package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SampleCLI {
    private static final String MAIN_MENU_DISPLAY_VENDING_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_TURN_HANDLE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_DISPLAY_VENDING_ITEMS, MAIN_MENU_OPTION_TURN_HANDLE, MAIN_MENU_OPTION_EXIT};
    private Path destFilePath = Paths.get("src/test/resources/DonQuixote-test.txt");

    private SampleMenu menu;

    public SampleCLI(SampleMenu menu) {
        this.menu = menu;
    }

    public void run() {
        Scanner userInput = new Scanner(System.in);
        String path = "C:\\Users\\Student\\workspace\\mod-1-capstone-java-team-2\\capstone\\vendingmachine.csv";
        File inventory = new File(path);
        //File inventory = new File();
       //boolean running = true;
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            //BubbleGumMachine bgm = new BubbleGumMachine(100, 10);
            if (choice.equals(MAIN_MENU_DISPLAY_VENDING_ITEMS)) {
                try(Scanner scanner = new Scanner(path){
                    while(scanner.){
                        System.out.println(scanner.nextLine());
                    }
                } catch (FileNotFoundException e){
                    System.out.println(e.getMessage());
                }
            } else if (choice.equals(MAIN_MENU_OPTION_TURN_HANDLE)) {
                // turn the handle
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {

                System.out.println();
                System.out.println("Thank you, have a good day!");
            }
        }
    }

    public static void main(String[] args) {
        SampleMenu menu = new SampleMenu(System.in, System.out);

        SampleCLI cli = new SampleCLI(menu);
        cli.run();
    }

}
