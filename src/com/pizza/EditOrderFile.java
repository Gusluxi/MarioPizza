package com.pizza;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//File, FileNotFoundException, IOException, FileWriter,


public class EditOrderFile {
    static ActiveOrders mariosActiveOrders = new ActiveOrders();
    static File PitzHistoric = new File("src\\com\\pizza\\PitzHistoric.txt");
    static File PitzHistoric2 = new File("src\\com\\pizza\\PitzHistoric2.txt");
    static Miscellaneous testMisc = new Miscellaneous();
    static TimeClass timeClass = new TimeClass();
    static Order order = new Order();
    // static Scanner scan = new Scanner(System.in);

    //Vi starter en ny ordre ved at oprette et order-objekt.
    //Vi beder om input omkring ordren og assigner attributer til dem til sidst.

    void startNewOrder() throws FileNotFoundException {
        boolean runMenu = true;
        Order order = new Order();
        String[] menuitems = {"1. Tilføj pizzaer til en ny order", "2. Vis Pizza Menukort",
                "3. Vis aktive ordrer", "4. for at retunerer til hovedmenu."};

        while (runMenu) {
            Menu menu = new Menu("Ny order menu:", "1,2 eller 3:", menuitems);
            menu.printMenu();
            int input = UserInput.inputInt("Vælg ");
            switch (input) {
                case 1:
                    //ADD PIZZA TO ORDER
                    addPizzaToOrder(order);
                    order.displayCurrentOrder("\nHele ordren:");

                    //GENERATE ORDER ID
                    order.setOrderID(testMisc.newOrderID());

                    //SET TIME FOR PICKUP
                    timeClass.askForTime(order);

                    //SEND TO ACTIVE ORDERS
                    mariosActiveOrders.addOrderToActiveOrders(order);

                    //DISPLAYING ACTIVE ORDERS
                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER:");
                    runMenu = false;
                    break;
                case 2:
                    PizzaMenuFile.printPizzaMenu2();
                    break;
                case 3:
                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER:");
                    break;
                case 4:
                    runMenu = false;
                    break;
                default:
                    System.out.println("Vælg 1. for ny order eller 4. for at annullere");
            }
        }
    }

    //editOrder() - Takes the order object and adds an
    void addPizzaToOrder(Order order) throws FileNotFoundException {
        boolean start = true;
        while (start) {
            order.addPizzaToOrder(PizzaMenuFile.findPizzaInMenu());
            order.displayCurrentOrder("Nye ordrer:");

            //Find ud af, om der skal bestilles flere pizzaer:
            int input = UserInput.inputInt(1, 2, "\n1. for at tilføje flere pizzaer " +
                    "\n2. for at gemme ordren");
            if (input == 2) {
                start = false;
            }
        }
    }
    //editOrder() - Takes the selected order and removes a selected pizza in a while loop.
    //If there is only one pizza left in the order it will ask to either delete the entire order or save it and finish the loop.
    void removePizzaFromOrderEO(Order order, int indexEdit) throws FileNotFoundException {
        int input = 1;
        if (order.getOrder().size() == 0)
            mariosActiveOrders.removeOrderFromList(indexEdit);
        else {
            order.displayCurrentOrder("Hele Ordren:");
            while (input == 1) {
                System.out.println(mariosActiveOrders.getActiveOrders().get(indexEdit).findPizzaNumber());
                mariosActiveOrders.getActiveOrders().get(indexEdit).removePizzaFromOrder(PizzaMenuFile.findPizzaInMenu());
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
    //editOrder() - Takes the selected order and asks for a time change.
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
    //Uses 1. addPizzaToOrder(Order) - 2. removePizzaFromOrderEO(Order, int) - 3. editOrderTime(int).
    void editOrder(int indexEdit) throws FileNotFoundException {
        String[] menuitems = {"1. for at tilføje flere pizzaer til ordren ", "2. for at slette enkelte pizzaer fra ordren",
                "3. for at ændre tiden for en ordren", "4. for at retunerer til hovedmenu."};
        Menu menu = new Menu("Rediger order:","1,2 eller 3:", menuitems);
        System.out.println("Du har valgt: " + mariosActiveOrders.getActiveOrders().get(indexEdit));
        menu.printMenu();
        int input = UserInput.inputInt("Vælg hvad du vil med ordren:");
            switch (input) {
                case 1:
                    addPizzaToOrder(mariosActiveOrders.getActiveOrders().get(indexEdit));
                    break;

                case 2:
                    removePizzaFromOrderEO(mariosActiveOrders.getActiveOrders().get(indexEdit), indexEdit);
                    break;

                case 3:
                    editOrderTime(indexEdit);
                    break;
                case 4:
                    //Ud til hovedmenu
                    break;
                default:
        }
    }

    //Vi skriver en Order ind i en textfil, så vi gemmer solgte ordre.
    public static void confirmOrderSold(Order order) throws IOException {
        FileWriter fw = new FileWriter(PitzHistoric,true);
        fw.write(order.toString());
        fw.write("\n");
        fw.close();

        sendToStats(order);

    }

    public static void sendToStats(Order order) throws IOException {
        FileWriter fw = new FileWriter(PitzHistoric2,true);
        fw.write(order.statsToString());
        fw.write("\n");
        fw.close();

        order.sortFileAlphabetically();

    }


 }