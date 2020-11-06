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
    //Vi beder om input omkring ordren og assigner attributer til dem til sidst.
    void startNewOrder() throws FileNotFoundException {
        Order order = new Order();
        TimeClass timeClass = new TimeClass();
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

        order.displayCurrentOrder("The complete order");

        //GENERATE ORDER ID
        order.setOrderID(testMisc.newOrderID());

        //SET TIME FOR PICKUP
        timeClass.askForTime(order);

        //SEND TO ACTIVE ORDERS
        mariosActiveOrders.addOrderToActiveOrders(order);

    }


    void editOrder(int editChosenOrder) throws FileNotFoundException {

        boolean start = true;
        while (start) {

            int input = UserInput.inputInt(1, 2, "\n1. for at tilføje flere pizzaer til ordren " +
                    "\n2. for at slette en pizza fra ordren");

            if (input == 1) {
                mariosActiveOrders.getActiveOrders().get(editChosenOrder).addPizzaToOrder(PizzaMenuFile.findAndAddToOrder());
                System.out.println("Den nye ordre: " + mariosActiveOrders.getActiveOrders().get(editChosenOrder));


                //Find ud af, om der skal bestilles flere pizzaer:
                int inputTilføjEllerStopEdit = UserInput.inputInt(1, 2, "\n1. for at tilføje flere pizzaer " +
                        "\n2. for at gemme den nye ordre");


                if (inputTilføjEllerStopEdit == 2) {
                    System.out.println("Ordren ser nu således ud: \n" + mariosActiveOrders.getActiveOrders().get(editChosenOrder));

                    start = false;
                }
            }
            editOrderTime(editChosenOrder);
        }
        start = false;
    }

    void editOrderTime(int editChosenOrder) {
        TimeClass timeClass = new TimeClass();
        Order order = new Order();

        System.out.println("\nSkal tidspunktet for pickup ændres?");

        boolean start = true;
        while (start) {

            int inputChangePickUpTime = UserInput.inputInt(1, 2, "1. Ændre pickup-tidspunkt " +
                    "\n2. Behold nuværende pickup-tidspunkt (" + mariosActiveOrders.getActiveOrders().get(editChosenOrder).getTime() + ")");

            if (inputChangePickUpTime == 1) {
                timeClass.askForTime(mariosActiveOrders.getActiveOrders().get(editChosenOrder));
            }
            if (inputChangePickUpTime == 2) {
                System.out.println("Ordren ser nu således ud: " + mariosActiveOrders.getActiveOrders().get(editChosenOrder));
                start = false;
            }
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