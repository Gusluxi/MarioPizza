package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistic {
    private final String FILENAME = "src\\com\\pizza\\PitzHistoric2.txt";


    void readStats() throws FileNotFoundException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();


        Scanner scanFile = new Scanner(new File(FILENAME));
        while (scanFile.hasNext()) {
            String word = scanFile.next();
            if ( map.containsKey(word)) {
                int count = map.get(word) + 1;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println(map);


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }




}