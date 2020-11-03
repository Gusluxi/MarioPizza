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
            String input = inputClass.inputString();

            while (menuList.hasNextLine()) {
                String lineFromText = menuList.nextLine();
                if (lineFromText.contains(input)) {
                   return lineFromText;
                }
            }
            //DEBUG
            System.out.println("length returns:" + menuTextFile.length());
        return "You fucked up bro";
        }

        void startNewOrder() throws FileNotFoundException {
            Order order = new Order();
            int input = 1;
            while (input == 1) {
                order.addPizzaToOrder(addToOrder());
                order.displayCurrentOrder();
                System.out.println("tast 1 for at tilføje flere pizzaer");
                input = inputClass.inputInt();
                System.out.println("besked over scan nextline");
                scan.nextLine(); //Scannerbuggen kommer vi udenom her.
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

