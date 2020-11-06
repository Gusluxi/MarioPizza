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

    //Takes the order object and adds an
    void addPizzaToOrder(Order order) throws FileNotFoundException {
        boolean start = true;
        while (start) {
            order.addPizzaToOrder(PizzaMenuFile.findAndReturnPizza());
            order.displayCurrentOrder("Nye ordrer:");

            //Find ud af, om der skal bestilles flere pizzaer:
            int input = UserInput.inputInt(1, 2, "\n1. for at tilføje flere pizzaer " +
                    "\n2. for at gemme ordren");
            if (input == 2) {
                start = false;
            }
        }
    }
    //Takes the selected order and removes a selected pizza in a while loop.
    //If there is only one pizza left in the order it will ask to either delete the entire order or save it and finish the loop.
    void removePizzaFromOrderEO(Order order, int indexEdit) throws FileNotFoundException {
        int input = 1;
        if (order.getOrder().size() == 0)
            mariosActiveOrders.removeOrderFromList(indexEdit);
        else {
            order.displayCurrentOrder("Hele Ordren:");
            while (input == 1) {
                System.out.println(mariosActiveOrders.getActiveOrders().get(indexEdit).findPizzaNumber());
                mariosActiveOrders.getActiveOrders().get(indexEdit).removePizzaFromOrder(PizzaMenuFile.findAndDeleteFromOrder());
                order.displayCurrentOrder("Hele Ordren:");

                if (order.getOrder().size() == 1 || order.getOrder().size() == 0) {
                    input = UserInput.inputInt(1, 2, "\n1. for at slette den sidste pizza og hele ordren " +
                            "\n2. for at gemme resten af ordren");
                    if (input == 1 || order.getOrder().size() == 0)
                        mariosActiveOrders.removeOrderFromList(indexEdit);
                    input = 2;
                } else if (order.getOrder().size() != 1) {
                    input = UserInput.inputInt(1, 2, "\n1. for at slette flere pizzaer " +
                            "\n2. for at gemme ordren");
                }
            }
        }
    }

    void editOrder(int indexEdit) throws FileNotFoundException {

        boolean start = true;
        while (start) {


            int input = UserInput.inputInt(1, 3, "\n1. for at tilføje flere pizzaer til ordren " +
                    "\n2. for at slette enkelte pizzaer fra ordren" +
                    "\n3. for at ændre tiden for en ordren");
            if (input==1) {
                addPizzaToOrder(mariosActiveOrders.getActiveOrders().get(indexEdit));
            }

            if (input == 2) {
                removePizzaFromOrderEO(mariosActiveOrders.getActiveOrders().get(indexEdit), indexEdit);
                }
            if (input == 3) {
                editOrderTime(indexEdit);
            }
                start = false;
        }
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
/*
    void removePizzaFromOrderEO(int indexEdit,Order order) throws FileNotFoundException {
        int input=1;
        while (input==1) {
            System.out.println(mariosActiveOrders.getActiveOrders().get(indexEdit).findPizzaNumber());
            System.out.println("Skriv pizza EO TEST");

            mariosActiveOrders.getActiveOrders().get(indexEdit).removePizzaFromOrder(PizzaMenuFile.findAndDeleteFromOrder());
            order.displayCurrentOrder("Nye ordrer:");

            input = UserInput.inputInt(1,2,"Vil du slette flere? \n1 for Ja, 2 for Nej");
            }
        }
*/





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