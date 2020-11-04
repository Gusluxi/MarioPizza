package com.pizza;

import java.io.*;

public class EditOrderFile {
    static ActiveOrders mariosActiveOrders = new ActiveOrders();
    static File PitzHistoric = new File("src\\com\\pizza\\PitzHistoric.txt");
    static Order order = new Order();
    static Miscellaneous testMisc = new Miscellaneous();

    //Vi starter en ny ordre ved at oprette et order-objekt.
    //Så beder vi Alfonso om at indtaste pizzaer
    //Sidst giver vi ordren et ID og displayer den.
    //ALLER SIDST SÆTTER VI DEN I AKTIVE ORDRE, SÅ MARIO KAN LÆSE DEM
    void startNewOrder() throws FileNotFoundException {
        Order order = new Order();
        boolean start = true;
        while (start) {
            order.addPizzaToOrder(PizzaMenuFile.findAndAddToOrder());
            order.displayCurrentOrder();

            //Find ud af, om der skal bestilles flere pizzaer:
            int input = UserInput.inputInt("\nTast 1 for at tilfQje flere pizzaer" +
                    "\nTast 0 for at gemme ordren");
            if (input==0) {
                start = false;
            }
        }
        System.out.println("Hele ordren: ");
        order.displayCurrentOrder();
        order.setOrderID(testMisc.newOrderID());

        mariosActiveOrders.addOrderToActiveOrders(order);
//OBS: addOrderToActiveOrders(order) sender hele Order ArrayList over til ActiveOrders ArrayList som en enkelt String i stede for mange Strings for hver Pizza.
    }

/*
    void generateOrderID(){
        int countID = order.getOrderID();
        if (countID != 0) {
            countID++;
            order.setOrderID(countID);
        } else order.setOrderID(3);
    }

 */

    void deleteActiveOrder(){
        mariosActiveOrders.manualRemoveOrderFromList(2);
    }

    public static void confirmOrderSold(Object order) throws IOException {
        FileWriter fw = new FileWriter(PitzHistoric,true);
        fw.write(order.toString());
        fw.write("\n");
        fw.close();
    }


    void testClass() throws IOException {
        //TEST... INDSÆTTER ORDERS



        //generateOrderID(); //Temp løsning til at generate et nyt OrderID for hvert object (kunne måske bruges i et loop)
        Order order2 = new Order(testMisc.newOrderID());
        //generateOrderID();
        Order order3 = new Order(testMisc.newOrderID());
        mariosActiveOrders.addOrderToActiveOrders(order2);
        mariosActiveOrders.addOrderToActiveOrders(order3);

        System.out.println("\n Alle Aktive Ordre");
        mariosActiveOrders.displayActiveOrders();
        confirmOrderSold(order2);
        deleteActiveOrder();
        confirmOrderSold(order3);
        System.out.println("\n");
        mariosActiveOrders.displayActiveOrders();
    }
}
