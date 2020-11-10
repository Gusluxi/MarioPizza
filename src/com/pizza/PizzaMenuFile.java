package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PizzaMenuFile {
    static File menuTextFile = new File("src\\com\\pizza\\PizzaMenu.txt");
    static File menuTextFile2 = new File("src\\com\\pizza\\PizzaMenu2.txt");


    //Finds the Chosen number from PizzaMenu.txt and sends a String with the chosen pizza.
        public static String findPizzaInMenu() throws FileNotFoundException {
            Scanner menuList = new Scanner(menuTextFile);

            int inputPizzaInt = UserInput.inputInt(1, 34, "Indtast nr. på en pizza!");
            String inputPizzaString = Integer.toString(inputPizzaInt);
            inputPizzaString += ".";

            while (menuList.hasNextLine()) {
                String lineFromText = menuList.nextLine();
                if (lineFromText.contains(inputPizzaString)) {
                    return lineFromText;
                }
            }
            return "Error - Kan ikke finde MenuFilen!";
        }


        //Scans and prints PizzaMenu2.txt
    static void printPizzaMenu2() throws FileNotFoundException {
        Scanner menuList = new Scanner(menuTextFile2);

        while (menuList.hasNextLine())
            System.out.println(menuList.nextLine());
    }
}

