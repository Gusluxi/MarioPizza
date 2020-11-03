package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class PizzaMenuFile {
    static Scanner scan = new Scanner(System.in);
    static File menuTextFile = new File("src\\com\\pizza\\PizzaMenu.txt");
    static ActiveOrders mariosActiveOrders = new ActiveOrders();
    static File PitzHistoric = new File("src/com/pizza/PitzHistoric");

        //Finder det valgte tal fra PizzaMenu.txt og sender en String med hele Pizzaen.
        public String findAddToOrder() throws FileNotFoundException {
            Scanner menuList = new Scanner(menuTextFile);

            System.out.println("Skriv nummer på pizza! (#nummer.)");
            int inputPizzaInt = UserInputClass.inputInt(0, 14);
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

    void printPizzaMenu() throws IOException {
        Scanner menuList = new Scanner(menuTextFile); // HER SMIDER VI IOException op i main.

        while (menuList.hasNextLine())
            System.out.println(menuList.nextLine());
    }

        //Vi starter en ny ordre ved at oprette et order-objekt.
        //Så beder vi Alfonso om at indtaste pizzaer
        //Sidst giver vi ordren et ID og displayer den.
        //ALLER SIDST SÆTTER VI DEN I AKTIVE ORDRE, SÅ MARIO KAN LÆSE DEM
        void startNewOrder() throws FileNotFoundException {
            Order order = new Order();
            boolean start = true;
            while (start) {
                order.addPizzaToOrder(findAddToOrder());
                order.displayCurrentOrder();

                //Find ud af, om der skal bestilles flere pizzaer:
                System.out.println("tast 1 for at tilfQje flere pizzaer");
                int input = UserInputClass.inputInt();
                if (input==0) {
                    start = false;
                }
            }
            System.out.println("Hele ordren ser sAdan her ud: ");
            order.displayCurrentOrder();
            order.setOrderID(generateOrderID());

            mariosActiveOrders.addOrderToActiveOrders(order);
        }


    int generateOrderID(){
        int count = 0;
        count++;
        return count;
    }

    void deleteActiveOrder(){
        mariosActiveOrders.manualRemoveOrderFromList(2);
    }

    void confirmOrderSold(Object order) throws FileNotFoundException {
        PrintStream writeToFile = new PrintStream(PitzHistoric); //throw filenotfound
        writeToFile.println(order.toString());
        }


    void testClass() throws FileNotFoundException {
        //TEST... INDSÆTTER ORDERS
        Order order2 = new Order(generateOrderID());
        Order order3 = new Order(generateOrderID());
        mariosActiveOrders.addOrderToActiveOrders(order2);
        mariosActiveOrders.addOrderToActiveOrders(order3);

        System.out.println("\n Alle Aktive Ordre");
        mariosActiveOrders.displayActiveOrders();
        confirmOrderSold(order3);
        deleteActiveOrder();
        System.out.println("\n");
        mariosActiveOrders.displayActiveOrders();
    }
}


//int var = order.getOrderID();
//System.out.printf("#%04d",var);