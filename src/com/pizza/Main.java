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
        EditOrderFile testEO = new EditOrderFile();
        Miscellaneous testMisc = new Miscellaneous();
        PizzaMenuFile.printPizzaMenu();
        TimeClass timeClass = new TimeClass();
        Order order1 = new Order(testMisc.newOrderID(),timeClass.setTimeOfTheDay(11,45),1145);
        Order order4 = new Order(testMisc.newOrderID(),timeClass.setTimeOfTheDay(9,45),945);
        Order order2 = new Order(testMisc.newOrderID(),timeClass.setTimeOfTheDay(9,30),930);
        Order order3 = new Order(testMisc.newOrderID(),timeClass.setTimeOfTheDay(12,15),1215);

        mariosActiveOrders.addOrderToActiveOrders(order1);
        mariosActiveOrders.addOrderToActiveOrders(order2);
        mariosActiveOrders.addOrderToActiveOrders(order3);
        mariosActiveOrders.addOrderToActiveOrders(order4);

        boolean run = true;
        int choice;
        String headertext = "Order Menu:";
        String leadtext = "Vaelg en mulighed: ";
        String[] menuitems = {"1. Add new order", "2. Display active orders", "3. Delete order",
                "4. Confirm order sold","Yayeet", "9. Exit program"};


        while (run){
            Menu menu = new Menu(headertext,leadtext,menuitems);
            menu.printMenu();
            choice = UserInput.inputInt(leadtext);

            switch (choice){
                case 1:
                    System.out.println("1. Add new order:");

                    testEO.startNewOrder();
                    break;
                case 2:
                    System.out.println("2. Active orders: ");
                    mariosActiveOrders.indexDisplayActiveOrders();
                    //mariosActiveOrders.displayActiveOrders("2. Active orders: "); Hvis vi vil se "hemmelig" tids-atribut (timeInt), som kan printes i toString under Order-class
                    break;
                case 3:
                    System.out.println("3. Delete order:");

                    mariosActiveOrders.indexDisplayActiveOrders();
                    int indexDel = (UserInput.inputInt("Input index number of order to delete: ") - 1);
                    System.out.print("DELETING ORDER: #" + indexDel+1 + " ");
                    mariosActiveOrders.printSelectedOrderFromList(indexDel); //Kan laves om til en "Are you sure you want to delete" + *ORDER* + " from the list" Type y or n.
                    mariosActiveOrders.removeOrderFromList(indexDel);
                    System.out.println("\nRemaining active orders:");
                    mariosActiveOrders.indexDisplayActiveOrders();

                    break;
                case 4:
                    System.out.println("4. Save completed order:");

                    mariosActiveOrders.indexDisplayActiveOrders();
                    int index = (UserInput.inputInt("Input index number of order to save: ") -1); //giver den første, når han skriver 1. (istedet for 0)
                    System.out.print("SAVING ORDER: #" + index+1 + " ");
                    mariosActiveOrders.printSelectedOrderFromList(index);
                    confirmOrderSold(mariosActiveOrders.getActiveOrders().get(index));
                    mariosActiveOrders.removeOrderFromList(index);
                    System.out.println("\nRemaining active orders:");
                    mariosActiveOrders.indexDisplayActiveOrders();
                    break;
                case 5:
                    System.out.println("yAyEEt");

                    break;
                case 9:
                    System.out.println("Exiting program...");
                    run = false;
                    break;
                default:
                    System.out.println("Choose something else :) ");
            }
        }
    }


    public static void main(String[] args) throws IOException {

        Main prg = new Main();
        prg.run();

    }
}
