package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistic {
    private final String FILENAME_NR = "src\\com\\pizza\\PitzHistoricNr.txt";
    private final String FILENAME_PRICE = "src\\com\\pizza\\PitzHistoricPrice.txt";

    /**
     * Method that uses Treemap to sort a map of keys and values.
     * Reads a file with every sold pizza and counts each individual sale.
     * @throws FileNotFoundException .
     */
    void readStatsPizzaNumber() throws FileNotFoundException {
        TreeMap<String, Integer> map = new TreeMap<>();

        Scanner scanFile = new Scanner(new File(FILENAME_NR));
        while (scanFile.hasNext()) {
            String word = scanFile.next();
            if (map.containsKey(word)) {
                int count = map.get(word) + 1;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("nr. #" + entry + " pizzaer solgt.");
        }
    }

    /**
     * Reads a file with every price total of prior sales.
     * Adds them up and prints the total.
     * @throws FileNotFoundException .
     */
    void readStatsTotalPrice() throws FileNotFoundException {
        int totalPriceInt = 0;
        Scanner scanFile = new Scanner(new File(FILENAME_PRICE));
        while (scanFile.hasNext()) {
            String singlePriceString = scanFile.next();
            totalPriceInt += Integer.parseInt(singlePriceString);
        }
        System.out.printf("\nOmsætning = %,d kr.\n", totalPriceInt);
    }
}





