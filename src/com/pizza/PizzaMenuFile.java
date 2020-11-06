package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PizzaMenuFile {
    static File menuTextFile = new File("src\\com\\pizza\\PizzaMenu.txt");
    static File menuTextFile2 = new File("src\\com\\pizza\\PizzaMenu2.txt");

    //Finder det valgte tal fra PizzaMenu.txt og sender en String med den valgte Pizza.
        public static String findAndAddToOrder() throws FileNotFoundException {
            Scanner menuList = new Scanner(menuTextFile);
            
            int inputPizzaInt = UserInput.inputInt(1, 14, "Skriv nr. på en pizza!");
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

        //Scanner Menuen og printer den..
    static void printPizzaMenu() throws FileNotFoundException {
        Scanner menuList = new Scanner(menuTextFile);

        while (menuList.hasNextLine())
           System.out.println(menuList.nextLine());
    }

    static void printPizzaMenu2() throws FileNotFoundException {
        Scanner menuList = new Scanner(menuTextFile2);

        while (menuList.hasNextLine())
            System.out.println(menuList.nextLine());
    }


}


//int var = order.getOrderID();
//System.out.printf("#%04d",var);