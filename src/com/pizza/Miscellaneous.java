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
    int generateOrderID() throws FileNotFoundException {
        int countID = readOrderID();
        countID ++;
        PrintStream writeToFile = new PrintStream(FILENAME);
        writeToFile.printf("%04d",countID);
        setCurrentOrderID(countID);
        return countID;
    }

    int newOrderID() throws FileNotFoundException {
        int ID = generateOrderID();
        return ID;

    }
}
