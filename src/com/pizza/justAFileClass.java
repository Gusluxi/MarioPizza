package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class justAFileClass {
    static Scanner scan = new Scanner(System.in);
    static File menuTextFile = new File("src\\com\\pizza\\PizzaMenu.txt");
    static ActiveOrders mariosActiveOrders = new ActiveOrders();

        //Vi læser i teksten og beder den finde et input vi giver
        public String findMenuItem() throws FileNotFoundException {
            Scanner menuList = new Scanner(menuTextFile);

            System.out.println("Skriv nummer på pizza! (#nummer.)");
            String inputPizzaString = scan.nextLine();

            while (menuList.hasNextLine()) {
                String lineFromText = menuList.nextLine();
                if (lineFromText.contains(inputPizzaString)) {
                   return lineFromText;
                }
            }
        return "You fucked up bro";
        }

        //Vi starter en ny ordre ved at oprette et order-objekt.
        //Så beder vi Alfonso om at indtaste pizzaer
        //Sidst giver vi ordren et ID og displayer den.
        //ALLER SIDST SÆTTER VI DEN I AKTIVE ORDRE, SÅ MARIO KAN LÆSE DEM
        void startNewOrder() throws FileNotFoundException {
            Order order = new Order();
            boolean test=true;
            while (test) {
                order.addPizzaToOrder(addToOrder());
                order.displayCurrentOrder();

                //Find ud af, om der skal bestilles flere pizzaer:
                System.out.println("tast 1 for at tilfQje flere pizzaer");
                int input = inputClass.inputInt();
                if (input==0) {
                    test=false;
                }
            }
            System.out.println("Hele ordren ser sAdan her ud: ");
            order.displayCurrentOrder();
            order.setOrderID(generateOrderID());

            mariosActiveOrders.addOrderToActiveOrders(order);

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

    int generateOrderID(){
        int count=1;

        return count;
    }


    void testClass(){
        //TEST... INDSÆTTER ORDERS
        Order order2 = new Order(generateOrderID());
        Order order3 = new Order(generateOrderID());
        mariosActiveOrders.addOrderToActiveOrders(order2);
        mariosActiveOrders.addOrderToActiveOrders(order3);


        System.out.println("\n Alle Aktive Ordre");
        mariosActiveOrders.displayActiveOrders();
    }

}


//int var = order.getOrderID();
//System.out.printf("#%04d",var);