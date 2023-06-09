package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String filePath = "vendingmachine.csv";
        File pathFile = new File(filePath);
        System.out.println();
        System.out.println("Sample Vending Machine.");
        System.out.println("Powered by Juan L.");
        try(Scanner scanner = new Scanner(pathFile)) {
            System.out.println();
            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine();
                System.out.println(lineOfText);
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.print("Please select an option: ");
        String userSelection = s





    }
}