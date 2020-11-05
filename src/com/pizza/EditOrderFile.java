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
        System.out.println("Hele ordren: ");
        order.displayCurrentOrder();
        order.setOrderID(testMisc.newOrderID());

        System.out.println("Enter time of completion. Start with hours:");
        int timeHourSat = UserInput.inputInt(0,23,"Must be a valid time! HOUR");
        System.out.println("test1");
        System.out.println("Enter minutes:");
        System.out.println("test2");
        int timeMinSat = UserInput.inputInt(0,59,"YAyeetFejl i indtastning MINUT");

        order.setTime(timeClass.setTimeOfTheDay(timeHourSat, timeMinSat));
        order.setTimeInt(order.convertTimetoTimeInt(order));
        System.out.println("test" + order.getTimeInt());
        System.out.println(order.getTime() + " TEST FOR AT TID BLIVER SAT. JAJAJAJJAA");
        mariosActiveOrders.addOrderToActiveOrders(order);
        mariosActiveOrders.displayActiveOrders();
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





/*
    void testClass() throws IOException {
        // Vores test class, hvor vi afprøver alt...
        TimeClass timeClass = new TimeClass();
        //timeClass.displayTime();
        //timeClass.displayInputTime(timeClass.setTimeOfTheDay(13,37));

        Order order1 = new Order(testMisc.newOrderID(),timeClass.setTimeOfTheDay(11,45),1145);
        Order order4 = new Order(testMisc.newOrderID(),timeClass.setTimeOfTheDay(9,45),945);
        Order order2 = new Order(testMisc.newOrderID(),timeClass.setTimeOfTheDay(9,30),930);
        Order order3 = new Order(testMisc.newOrderID(),timeClass.setTimeOfTheDay(12,15),1215);
        mariosActiveOrders.addOrderToActiveOrders(order1);
        mariosActiveOrders.addOrderToActiveOrders(order2);
        mariosActiveOrders.addOrderToActiveOrders(order3);
        mariosActiveOrders.addOrderToActiveOrders(order4);



        System.out.println("\n Alle Aktive Ordre");
        mariosActiveOrders.displayActiveOrders();
        //confirmOrderSold(order2);
        //deleteActiveOrder();

        //confirmOrderSold(order3);
        System.out.println("\nSorted by time:");

        mariosActiveOrders.sortByAttribute();


 */
