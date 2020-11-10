package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistic {
    //Second file for working with the statistics
    private final String FILENAME = "src\\com\\pizza\\PitzHistoric2.txt";

    //TreeMap that sorts the statistics file.
    void readStats() throws FileNotFoundException {
        TreeMap<String, Integer> map = new TreeMap<>();


        Scanner scanFile = new Scanner(new File(FILENAME));
        while (scanFile.hasNext()) {
            String word = scanFile.next();
            if (map.containsKey(word)) {
                int count = map.get(word) + 1;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }
        //Outputs the map line by line.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Pizzanummer: "+entry.getKey() +", Antal solgte: "+ entry.getValue());
        }
    }
}




