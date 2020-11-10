package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Miscellaneous {
    private final String FILENAME = "src\\com\\pizza\\OrderID.txt";
    private int currentOrderID;

    public int getCurrentOrderID() {
        return currentOrderID;
    }

    public void setCurrentOrderID(int currentOrderID) {
        this.currentOrderID = currentOrderID;
    }

    //Denne metode læser en fil og returner tallet i filen.
    int readOrderID() {
        try {
            Scanner iDFileScan = new Scanner(new File(FILENAME));
            String stringID = iDFileScan.nextLine();
            int intID = Integer.parseInt(stringID);
            setCurrentOrderID(intID);
            return intID;

        } catch (IOException e) {
            System.out.println("\nCould not open file - I/O Exception" + e);
        }
        return -1;
    }

    //Denne metode henter et integer fra ovenstående metode, plusser med 1, og setter IDet til ordren + noterer det i filen
    int newOrderID() throws FileNotFoundException {
        int countID = readOrderID();
        countID ++;
        PrintStream writeToFile = new PrintStream(FILENAME);
        writeToFile.printf("%04d",countID);
        setCurrentOrderID(countID);
        return countID;
    }

}

