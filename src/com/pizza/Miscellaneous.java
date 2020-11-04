package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Miscellaneous {
    private final String FILENAME = "src\\com\\pizza\\OrderID.txt";
    private int currentOrderID;

    int readOrderID() {

        try {
            Scanner iDFileScan = new Scanner(new File("src\\com\\pizza\\OrderID.txt"));
            String stringID = iDFileScan.nextLine();
            int intID = Integer.parseInt(stringID);
            this.currentOrderID = intID;
            return intID;

        } catch (IOException e) {
            System.out.println("\nCould not open file - I/O Exception" + e);
        }
        return -1;
    }
    void generateOrderID() throws FileNotFoundException {
        int countID = readOrderID();
        countID ++;
        PrintStream writeToFile = new PrintStream("src\\com\\pizza\\OrderID.txt");
        writeToFile.printf("%04d",countID);
        this.currentOrderID = countID;
    }

    int newOrderID() throws FileNotFoundException {
            generateOrderID();
            int iD = this.currentOrderID;
        System.out.printf("%04d", iD);
        return iD;

    }
}
