package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class PizzaMenuFile {
    static File menuTextFile = new File("src\\com\\pizza\\PizzaMenu.txt");

        //Finder det valgte tal fra PizzaMenu.txt og sender en String med den valgte Pizza.
        public static String findAndAddToOrder() throws FileNotFoundException {
            Scanner menuList = new Scanner(menuTextFile);

            System.out.println("Skriv nummer på pizza! (#nummer.)");
            int inputPizzaInt = UserInput.inputInt(0, 14, "Skriv nr. mellem 1-14");
            String inputPizzaString = Integer.toString(inputPizzaInt);
            inputPizzaString += ".";

            while (menuList.hasNextLine()) {
                String lineFromText = menuList.nextLine();
                if (lineFromText.contains(inputPizzaString)) {
                    return lineFromText;
                }
            }
            return "Error - This program sucks";
        }

    static void printPizzaMenu() throws IOException {
        Scanner menuList = new Scanner(menuTextFile); // HER SMIDER VI IOException op i main.

        while (menuList.hasNextLine())
            System.out.println(menuList.nextLine());
    }

}


//int var = order.getOrderID();
//System.out.printf("#%04d",var);