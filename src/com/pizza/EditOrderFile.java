package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//File, FileNotFoundException, IOException, FileWriter,

public class EditOrderFile {
    static ActiveOrders mariosActiveOrders = new ActiveOrders();
    static File PitzHistoric = new File("src\\com\\pizza\\PitzHistoric.txt");
    static Miscellaneous testMisc = new Miscellaneous();
    static TimeClass timeClass = new TimeClass();
    static Order order = new Order();
    // static Scanner scan = new Scanner(System.in);

    //Vi starter en ny ordre ved at oprette et order-objekt.
    //Vi beder om input omkring ordren og assigner attributer til dem til sidst.

    void startNewOrder() throws FileNotFoundException {
        Order order = new Order();

        //ADD PIZZA TO ORDER
        addPizzaToOrder(order);

        order.displayCurrentOrder("Dette er hele ordren:");

        //GENERATE ORDER ID
        order.setOrderID(testMisc.newOrderID());

        //SET TIME FOR PICKUP
        timeClass.askForTime(order);

        //SEND TO ACTIVE ORDERS
        mariosActiveOrders.addOrderToActiveOrders(order);

    }


    void addPizzaToOrder(Order order) throws FileNotFoundException {
        boolean start = true;
        while (start) {
            order.addPizzaToOrder(PizzaMenuFile.findAndAddToOrder());
            order.displayCurrentOrder("Nye ordrer:");

            //Find ud af, om der skal bestilles flere pizzaer:
            int input = UserInput.inputInt(1, 2, "\n1. for at tilføje flere pizzaer " +
                    "\n2. for at gemme ordren");
            if (input == 2) {
                start = false;
            }
        }
    }

    void editOrder(int indexEdit) throws FileNotFoundException {

        boolean start = true;
        while (start) {

            int input = UserInput.inputInt(1, 2, "\n1. For at tilføje flere pizzaer til ordren " +
                    "\n2. Slet enkelte pizzaer fra ordren.");
            if (input==1) {
                addPizzaToOrder(mariosActiveOrders.getActiveOrders().get(indexEdit));
            }

            if (input == 2) {
                removePizzaFromOrderEO(indexEdit);
                }

            start = false;
        }
            editOrderTime(indexEdit);
        }



    void editOrderTime(int indexEdit) {
        TimeClass timeClass = new TimeClass();

        System.out.println("\nSkal tidspunktet for pickup ændres?");

        boolean start = true;
        while (start) {

            int inputChangePickUpTime = UserInput.inputInt(1, 2, "1. Ændre pickup-tidspunkt " +
                    "\n2. Behold nuværende pickup-tidspunkt (" + mariosActiveOrders.getActiveOrders().get(indexEdit).getTime() + ")");

            if (inputChangePickUpTime == 1) {
                timeClass.askForTime(mariosActiveOrders.getActiveOrders().get(indexEdit));
            }
            if (inputChangePickUpTime == 2) {
                System.out.println("Ordren ser nu således ud: " + mariosActiveOrders.getActiveOrders().get(indexEdit));

            }
            start = false;
        }
    }

    //ORDREN mariosActiveOrders.getActiveOrders().get(indexEdit))

    void removePizzaFromOrderEO(int indexEdit) throws FileNotFoundException {
        boolean start = true;
        while (start) {
            String lala;

            System.out.println(mariosActiveOrders.getActiveOrders().get(indexEdit).findPizzaNumber());
            System.out.println("Skriv pizza");
            String inputRemovePizzaName = UserInput.inputString();
            mariosActiveOrders.getActiveOrders().get(indexEdit).removePizzaFromOrder(inputRemovePizzaName);
            order.displayCurrentOrder("Nye ordrer:");


            }
        }






    //Vi skriver en Order ind i en textfil, så vi gemmer solgte ordre.
    public static void confirmOrderSold(Object order) throws IOException {
        FileWriter fw = new FileWriter(PitzHistoric,true);
        fw.write(order.toString());
        fw.write("\n");
        fw.close();
    }
 }

 /*
    void deleteActiveOrder(int indexInput){
        mariosActiveOrders.removeOrderFromList(indexInput);
    }
 */