package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//File, FileNotFoundException, IOException, FileWriter,

public class EditOrderFile {
    static ActiveOrders mariosActiveOrders = new ActiveOrders();
    static File PitzHistoric = new File("src\\com\\pizza\\PitzHistoric.txt");
    static Order order = new Order();
    static Miscellaneous testMisc = new Miscellaneous();
    static Scanner scan = new Scanner(System.in);


    //Vi starter en ny ordre ved at oprette et order-objekt.
    //Så beder vi Alfonso om at indtaste pizzaer
    //Sidst giver vi ordren et ID og displayer den.
    //ALLER SIDST SÆTTER VI DEN I AKTIVE ORDRE, SÅ MARIO KAN LÆSE DEM

    void startNewOrder() throws FileNotFoundException {
        Order order = new Order();
        TimeClass timeClass = new TimeClass();
        boolean start = true;
        while (start) {
            order.addPizzaToOrder(PizzaMenuFile.findAndAddToOrder());
            order.displayCurrentOrder();

            //Find ud af, om der skal bestilles flere pizzaer:
            int input = UserInput.inputInt("\nTast 1 for at tilfQje flere pizzaer" +
                    "\nTast 0 for at gemme ordren");
            if (input == 0) {
                start = false;
            }
        }
        System.out.println("The complete order: ");
        order.displayCurrentOrder();

        //GENERATE ORDER ID
        order.setOrderID(testMisc.newOrderID());

        //SET TIME FOR PICKUP
        timeClass.askForTime(order);

        //SEND TO ACTIVE ORDERS
        mariosActiveOrders.addOrderToActiveOrders(order);

    }


    void deleteActiveOrder(int indexInput){
        mariosActiveOrders.removeOrderFromList(indexInput);
    }

    public static void confirmOrderSold(Object order) throws IOException {
        FileWriter fw = new FileWriter(PitzHistoric,true);
        fw.write(order.toString());
        fw.write("\n");
        fw.close();
    }


    }
