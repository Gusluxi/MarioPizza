package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class deals with the creating of OrderID numbers. It reads/writes numbers from a file.
 */

public class Miscellaneous {
    private final String FILENAME = "src\\com\\pizza\\OrderID.txt";
    private int currentOrderID;

    public void setCurrentOrderID(int currentOrderID) {
        this.currentOrderID = currentOrderID;
    }

    /**
     * This method reads the ORDERID-file and returns the number
     * @return the current ID in the file
     */
    int readOrderID() {
        try {
            Scanner idFileScan = new Scanner(new File(FILENAME));
            String stringID = idFileScan.nextLine();
            int intID = Integer.parseInt(stringID);
            return intID;

        } catch (IOException e) {
            System.out.println("\nCould not open file - I/O Exception" + e);
        }
        return -1;
    }

    /**
     * Gets the OrderID from the method above and adds 1. (Also saves the newest OrderID in the file.)
     * @return the ID from the file
     * @throws FileNotFoundException .
     */
    int newOrderID() throws FileNotFoundException {
        int countID = readOrderID();
        countID ++;
        PrintStream writeToFile = new PrintStream(FILENAME);
        writeToFile.printf("%04d",countID);
        setCurrentOrderID(countID);
        return countID;
    }

}

