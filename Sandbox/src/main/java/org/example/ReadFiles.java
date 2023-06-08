package org.example;

import java.io.File;
import java.util.Scanner;

public class ReadFiles {

    Scanner userInput = new Scanner(System.in);
    // Prompt the user for a file path - path should look like "data/jekyll-and-hyde.txt"
        System.out.print("Enter path to the book file: ");
    String filePath = userInput.nextLine();

    /*
    Step 2: Step Two: Open the book file and handle errors
     */
    // Create a File object using the path
    File bookFile = new File(filePath);
    // Setup some variables used in the loop
    boolean inBookText = false; // Are you reading between the start and end markers?
    int lineCount = 0;          // Count of lines between the start and end markers.

    // Open the file
        try (Scanner fileInput = new Scanner(bookFile)) {
            /*
            Step 3: Create a read loop and process the lines
             */
        // Loop until the end of file is reached
        while (fileInput.hasNextLine()) {
            // Read the next line into 'lineOfText'
            String lineOfText = fileInput.nextLine();
}
