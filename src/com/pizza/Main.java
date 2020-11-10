package com.pizza;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.pizza.EditOrderFile.*;
import static com.pizza.PizzaMenuFile.*;

public class Main {

    static Scanner menuList;
    {
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
        String leadtext = "Vælg en mulighed: ";
        String[] menuitems = {"1. Ny order.", "2. Vis aktive ordrer.", "3. Gem en betalt order.",
                "4. Slet en order.","5. Rediger en order.","6. Vis Pizza Menukort","7. Vis Statestik over solgte pizzaer.", "9. Afslut program"};


        while (run){
            Menu menu = new Menu(headertext,leadtext,menuitems);
            menu.printMenu();
            choice = UserInput.inputInt(leadtext);
            switch (choice){
                case 1:
                    System.out.println("1. Add new order.");
                    editOrderFile.startNewOrder();
                    break;
                case 2:
                    System.out.println("2. Viser alle aktive ordrer.\n");
                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER:");
                    //mariosActiveOrders.displayActiveOrders("2. Active orders: "); Hvis vi vil se "hemmelig" tids-atribut (timeInt), som kan printes i toString under Order-class
                    break;
                case 3:
                    System.out.println("3. Gem en betalt order.\n");
                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER: \n0.  For at annullerer");
                    int index = (UserInput.inputInt("Skriv #index af order der skal gemmes:") -1); //giver den første, når han skriver 1. (istedet for 0)
                    if (index == -1)
                    System.out.print("GEMMER ORDER: #" + index+1 + " ");
                    mariosActiveOrders.printSelectedOrderFromList(index);
                    confirmOrderSold(mariosActiveOrders.getActiveOrders().get(index));
                    mariosActiveOrders.removeOrderFromList(index);
                    mariosActiveOrders.indexDisplayActiveOrders("Resterende aktive ordrer:");
                    break;
                case 4:
                    System.out.println("4. Slet en order.\n");

                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER: \n0.  For at annullerer");
                    int indexDel = (UserInput.inputInt("Skriv #index af order der skal slettes:") - 1);
                    if (indexDel == -1)
                    System.out.print("SLETTER ORDER: #" + indexDel+1 + " ");
                    mariosActiveOrders.printSelectedOrderFromList(indexDel); //Kan laves om til en "Are you sure you want to delete" + *ORDER* + " from the list" Type y or n.
                    mariosActiveOrders.removeOrderFromList(indexDel);
                    mariosActiveOrders.indexDisplayActiveOrders("Resterende aktive ordrer:");
                    break;
                case 5:
                    mariosActiveOrders.indexDisplayActiveOrders("AKTIVE ORDRER:");
                    int indexEdit = (UserInput.inputInt("Input index number of order to edit: ") -1);
                    editOrderFile.editOrder(indexEdit);
                    break;
                case 6:
                    PizzaMenuFile.printPizzaMenu2();
                    break;
                case 7:
                    stats.readStats();
                    break;
                case 9:
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
