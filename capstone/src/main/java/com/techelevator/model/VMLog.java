package com.techelevator.model;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.techelevator.view.Menu;

public class VMLog {

    private static PrintWriter pw = null;


    public static void log(String message){
        try {
            if(pw == null){
//                String logFilename = "logs/" + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + ".log";
//                pw = new PrintWriter(new FileOutputStream(logFilename));

                File logFilename = new File("Log.txt");
                logFilename.createNewFile();
                pw = new PrintWriter(new FileOutputStream(logFilename));
            }

        }catch (FileNotFoundException e){
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Took this outside of the try loop because it would never print the first user transaction.
        pw.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE) + " " + message);
        pw.flush();

    }
}
