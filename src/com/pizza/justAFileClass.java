package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class justAFileClass {
    static Scanner scan = new Scanner(System.in);
    static File menuTextFile = new File("src\\com\\pizza\\PizzaMenu.txt");


        //Vi læser i teksten og beder den finde et input vi giver
        //Derefter printer vi linjen i konsol.. Det skal sendes til Display i fremtiden.

        public String findMenuItem() throws FileNotFoundException {
            Scanner menuList = new Scanner(menuTextFile);

            System.out.println("Skriv nummer på pizza! (#nummer.)");
            String inputPizzaString = inputClass.inputString();

            while (menuList.hasNextLine()) {
                String lineFromText = menuList.nextLine();
                if (lineFromText.contains(inputPizzaString)) {
                   return lineFromText;
                }
            }
        return "You fucked up bro";
        }

        void startNewOrder() throws FileNotFoundException {
            Order order = new Order();
            boolean test=true;
            while (test) {
                order.addPizzaToOrder(addToOrder());

                order.displayCurrentOrder();
                System.out.println("tast 1 for at tilføje flere pizzaer");

                //Find ud af, om der skal bestilles flere pizzaer:
                int input = inputClass.inputInt();
                if (input==0) {
                    test=false;
                }
            }
            System.out.println("wutwut");

        }

        String addToOrder() throws FileNotFoundException {
            return findMenuItem();
        }

    void printFileMethod() throws IOException {
        Scanner menuList = new Scanner(menuTextFile); // HER SMIDER VI IOException op i main.
        while (menuList.hasNextLine()) {
            String nextLineInText = menuList.nextLine();
            System.out.println(nextLineInText);
        }
    }


    }

