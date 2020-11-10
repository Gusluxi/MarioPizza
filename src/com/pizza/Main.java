package com.pizza;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.pizza.EditOrderFile.*;
import static com.pizza.PizzaMenuFile.*;

public class Main {

    static Scanner menuList;
    static {
        try {
            menuList = new Scanner(menuTextFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void run() throws IOException { // MENU
        //Variables and instances of classes
        EditOrderFile editOrderFile = new EditOrderFile();
        TimeClass timeClass = new TimeClass();
        Statistic stats = new Statistic();

        TestSimulationCode testSimulationCode = new TestSimulationCode();
        testSimulationCode.insertTestSimulatedCode(); //Insert fake orders to show off

        //Run the menu here:
        mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER:");

        boolean run = true;
        int choice;
        String headertext = "Mario's Pizza  -  kl. " + timeClass.displayTime();
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuitems = {"1. Ny order.", "2. Vis aktive ordrer m. pris.", "3. Gem en betalt order.",
                "4. Slet en order.","5. Rediger en order.","6. Vis Pizza Menukort.","7. Vis Statestik for antal solgte pizzaer og omsaetning.", "9. Afslut program."};

        while (run){
            Menu menu = new Menu(headertext,leadtext,menuitems);
            menu.printMenu();
            choice = UserInput.inputInt(leadtext);
            switch (choice){
                case 1: //Creates new order
                    System.out.println("1. Start ny order. \n");
                    editOrderFile.startNewOrder();
                    break;
                case 2: //Displays orders
                    System.out.println("2. Viser alle aktive ordrer.\n");
                    mariosActiveOrders.indexPriceDisplayActiveOrders("AKTIVE ORDRER:");
                    break;
                case 3: //Saves an order in a file for record-keeping.
                    System.out.println("3. Gem en betalt order.\n");
                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER: \n0.  For at annullerer");

                    // "-1" makes sure the index numbers aren't 0.
                    int index = (UserInput.inputInt(0,mariosActiveOrders.getActiveOrders().size(),"Indtast #index af order der skal gemmes:") -1);
                    if (index == -1)
                    System.out.print("GEMMER ORDER: #" + index+1 + " ");
                    mariosActiveOrders.printSelectedOrderFromList(index);
                    confirmOrderSold(mariosActiveOrders.getActiveOrders().get(index));
                    mariosActiveOrders.removeOrderFromList(index);
                    mariosActiveOrders.indexDisplayActiveOrders("Resterende aktive ordrer:");
                    break;
                case 4: //Deletes an order, in case customer doesn't show up.
                    System.out.println("4. Slet en order.\n");
                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER: \n0.  For at annullerer");

                    // "-1" makes sure the index numbers aren't 0.
                    int indexDel = (UserInput.inputInt(0,mariosActiveOrders.getActiveOrders().size(),"Indtast #index af order der skal slettes:") - 1);
                    if (indexDel >0) {
                      System.out.print("SLETTER ORDER: #" + indexDel+1 + " ");
                      mariosActiveOrders.printSelectedOrderFromList(indexDel);
                      mariosActiveOrders.removeOrderFromList(indexDel);
                      mariosActiveOrders.indexDisplayActiveOrders("Resterende aktive ordrer:");
                    }
                    break;
                case 5: //Lets the user edit an existing file.
                    System.out.println("5. Rediger en order. \n");
                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER:");
                    int indexEdit = (UserInput.inputInt(0,mariosActiveOrders.getActiveOrders().size(),"Indtast #index af order der skal redigeres: ") -1);
                    editOrderFile.editOrder(indexEdit);
                    break;
                case 6: //Prints the Menu
                    System.out.println("6. Vis Pizza Menu. \n");
                    PizzaMenuFile.printPizzaMenu2();
                    break;
                case 7: //Prints the statistics of former purchases.
                    System.out.println("7. Vis Statistik. \n");
                    stats.readStatsPizzaNumber();
                    stats.readStatsTotalPrice();
                    break;
                case 9: //Terminates program (if needed).
                    System.out.println("Afslutter program...");
                    run = false;
                    break;
                default:
                    menu.printMenu();
            }
        }
    }


    public static void main(String[] args) throws IOException {

        Main prg = new Main();
        prg.run();

    }
}
