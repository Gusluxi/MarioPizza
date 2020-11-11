package com.pizza;

//File, FileNotFoundException, FileWriter, File (Written to keep track in case of java.io.* happening)
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Order Class deals with everything related to changing/creating/deleting orders.
 * Calls upon other classes (such as TimeClass) to assign specific attributes
 * Stores information in 3 separate text-files (PitzHistoric, -Nr & Price.)
 */

public class EditOrderFile {
    static ActiveOrders mariosActiveOrders = new ActiveOrders();
    static File soldPizzas = new File("src\\com\\pizza\\PitzHistoric.txt");
    static File soldPizzas2 = new File("src\\com\\pizza\\PitzHistoricNr.txt");
    static File soldPizzas3 = new File("src\\com\\pizza\\PitzHistoricPrice.txt");
    static Miscellaneous miscellaneous = new Miscellaneous();
    static TimeClass timeClass = new TimeClass();


    /**
     * Creates an order-instance and calls other methods to assign values
     * @throws FileNotFoundException .
     */
    void startNewOrder() throws FileNotFoundException {
        boolean runMenu = true;
        Order order = new Order();
        String[] menuitems = {"1. Indtast pizzaer til en ny order", "2. Vis Pizza Menukort",
                "3. Vis aktive ordrer", "4. for at retunerer til hovedmenu."};

        while (runMenu) {
            Menu menu = new Menu("Ny order menu:", "1,2 eller 3:", menuitems);
            menu.printMenu();
            int input = UserInput.inputInt("Indtast en valgmulighed: ");
            switch (input) {
                case 1:
                    //ADD PIZZA TO ORDER
                    addPizzaToOrder(order);
                    order.displayCurrentOrder("\nHele ordren:");

                    //GENERATE ORDER ID
                    order.setOrderID(miscellaneous.newOrderID());

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
                    System.out.println("Tast 1. for ny order eller 4. for at annullere");
            }
        }
    }

    /**
     * Starts a whileloop to determine how many pizzas you want to assign to your order.
     * @param order any given order
     * @throws FileNotFoundException .
     */
    void addPizzaToOrder(Order order) throws FileNotFoundException {
        boolean start = true;
        while (start) {
            order.addPizzaToOrder(PizzaMenuFile.findPizzaInMenu());
            order.displayCurrentOrder("Nye ordrer:");

            //Press 1 for more pizzas, 2 to save order.
            int input = UserInput.inputInt(1, 2, "\n1. for at indtaste flere pizzaer " +
                    "\n2. for at gemme ordren til aktive ordrer");
            if (input == 2) {
                start = false;
            }
        }
    }

    /**
     * Takes the selected order and removes a selected pizza in a while loop.
     * If there is only one pizza left in the order it will ask to either delete the entire order or save it and finish the loop.
     * @param order any given order
     * @param indexEdit our user input, indexEdit is called in Main
     * @throws FileNotFoundException .
     */
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
                            "\n2. for at gemme resten af ordren til aktive ordrer ");
                    if (input == 1 || order.getOrder().size() == 0)
                        mariosActiveOrders.removeOrderFromList(indexEdit);
                    input = 2;
                } else if (order.getOrder().size() != 1) {
                    input = UserInput.inputInt(1, 2, "\n1. for at slette flere pizzaer " +
                            "\n2. for at gemme ordren til aktive ordrer ");
                }
            }
        }
    }

    /**
     * Uses index as a parameter and asks the user to specify the time.
     * @param indexEdit our user input, indexEdit is called in Main
     */
    void editOrderTime(int indexEdit) {
        TimeClass timeClass = new TimeClass();

        System.out.println("\nSkal tidspunktet for afhentningen redigeres?");

        boolean start = true;
        while (start) {

            int inputChangePickUpTime = UserInput.inputInt(1, 2, "1. Rediger afhentnings-tidspunkt " +
                    "\n2. Behold afhentnings-tidspunktet: (" +
                    mariosActiveOrders.getActiveOrders().get(indexEdit).getTime() + ") ");

            if (inputChangePickUpTime == 1) {
                timeClass.askForTime(mariosActiveOrders.getActiveOrders().get(indexEdit));
            } else {
                System.out.println("Den redigeret order: " + mariosActiveOrders.getActiveOrders().get(indexEdit));
            }
            start = false;
        }
    }


    /**
     * Expanded the menu when the user is editing orders.
     * @param indexEdit our user input, indexEdit is called in Main
     * @throws FileNotFoundException .
     */
    void editOrder(int indexEdit) throws FileNotFoundException {
        String[] menuitems = {"1. Indtast flere pizzaer til ordren ", "2. Slet enkelte pizzaer fra ordren",
                "3. Rediger tiden til ordren", "4. Retunerer til hovedmenu."};
        Menu menu = new Menu("Rediger order:","1,2 eller 3:", menuitems);
        System.out.println("Du har valgt: " + mariosActiveOrders.getActiveOrders().get(indexEdit));
        menu.printMenu();

        int input = UserInput.inputInt("Indtast hvad du vil med ordren:");
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
                default:
                    System.out.println("\n");
        }
    }

    /**
     * Saves a given order to a text-file.
     * @param order Any given order
     * @throws IOException .
     */
    public static void confirmOrderSold(Order order) throws IOException {
        FileWriter fw = new FileWriter(soldPizzas,true);
        fw.write(order.toString());
        fw.write("\nTotal: " + order.findTotalPizzaPrice() + " kr.");
        fw.write("\n");
        fw.close();

        sendToStats(order);
        sendToStats2(order);

    }

    /**
     * When an order is confirmed, the stats of pizzas sold is stored in another file for record keeping.
     * @param order Any given order
     * @throws IOException .
     */
    public static void sendToStats(Order order) throws IOException {
        FileWriter fw = new FileWriter(soldPizzas2,true);
        fw.write(order.pizzaNumberToString());
        fw.write("\n");
        fw.close();

        order.sortFileAlphabetically();
    }

    /**
     * When an order is confirmed, the total cost is stored in another file for record keepint.
     * @param order any given order.
     * @throws IOException  .
     */
    public static void sendToStats2(Order order) throws IOException {
        FileWriter fw = new FileWriter(soldPizzas3,true);
        fw.write(order.priceStatsToString());
        fw.write("\n");
        fw.close();

    }
 }