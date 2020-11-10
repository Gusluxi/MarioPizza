package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PizzaMenuFile {
    static File menuTextFile = new File("src\\com\\pizza\\PizzaMenu.txt");
    static File menuTextFile2 = new File("src\\com\\pizza\\PizzaMenu2.txt");
    //static Scanner menuList = new Scanner(menuTextFile);

    //Finder det valgte tal fra PizzaMenu.txt og sender en String med den valgte Pizza.
        public static String findPizzaInMenu() throws FileNotFoundException {
            Scanner menuList = new Scanner(menuTextFile);

            int inputPizzaInt = UserInput.inputInt(1, 34, "Skriv nr. på en pizza!");
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


        //Scanner PizzaMenu2.txt og printer den..
    static void printPizzaMenu2() throws FileNotFoundException {
        Scanner menuList = new Scanner(menuTextFile2);

        while (menuList.hasNextLine())
            System.out.println(menuList.nextLine());
    }
}

