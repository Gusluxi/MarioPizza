package com.pizza;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Statistic {
    private final String FILENAMEPH = "src\\com\\pizza\\PitzHistoric.txt";
    private int currentPizza;


    public int getCurrentPizza() {
        return currentPizza;
    }
    public void setCurrentPizza(int currentPizza) {
        this.currentPizza = currentPizza;
    }

    int readOrderID ( int piznr){
        int counter = 0;
        try {
            Scanner pitzFileScan = new Scanner(new File(FILENAMEPH));
            do {
                String stringPitz = pitzFileScan.nextLine();
                if (stringPitz.contains(piznr + ","))
                    counter++;
                setCurrentPizza(counter);
                int intPitz = Integer.parseInt(stringID);
                setCurrentOrderID(intID);
                return intID;
            } while (pitzFileScan.hasNextLine());
        } catch (IOException e) {
            System.out.println("\nCould not open file - I/O Exception" + e);
        }
        return -1;
    }
}