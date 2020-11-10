package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistic {
    private final String FILENAME_NR = "src\\com\\pizza\\PitzHistoricNr.txt";
    private final String FILENAME_PRICE = "src\\com\\pizza\\PitzHistoricPrice.txt";


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

    void readStatsTotalPrice() throws FileNotFoundException {
        int totalPriceInt = 0;
        Scanner scanFile = new Scanner(new File(FILENAME_PRICE));
        while (scanFile.hasNext()) {
            String singlePriceString = scanFile.next();
            totalPriceInt += Integer.parseInt(singlePriceString);
        }
        System.out.printf("\nOmsaetning = %,d kr.\n", totalPriceInt);
    }
}





