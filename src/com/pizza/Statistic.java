package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Statistic {
    private final String FILENAME = "src\\com\\pizza\\PitzHistoric.txt";

    void readFileTest() throws FileNotFoundException {
        Scanner scanFile = new Scanner(new File(FILENAME));
        int var=0;
        System.out.println("TEST");
            while (scanFile.hasNext()) {
                String nextWord = scanFile.next();
                if (nextWord.contains("01,")) {
                    System.out.println("Fundet!");
                    var++;


                }
            }

        System.out.println(var);
    }
}

