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
                    System.out.println("1. Add new order");
                    testEO.startNewOrder();
                    break;
                case 2:
                    System.out.println("2. Display orders");
                    mariosActiveOrders.displayActiveOrders();

                    break;
                case 3:
                    System.out.println("Delete order");
                    mariosActiveOrders.deleteDisplayActiveOrders();
                    mariosActiveOrders.removeOrderFromList(UserInput.inputInt("Input index number of Order")-1);

                    break;
                case 4:
                    System.out.println("Save order");
                    mariosActiveOrders.displayActiveOrders();
                    int index = (UserInput.inputInt("Input index number of order") -1); //giver den første, når han skriver 1. (istedet for 0)
                    confirmOrderSold(mariosActiveOrders.getActiveOrders().get(index));
                    mariosActiveOrders.removeOrderFromList(index);

                    System.out.println("Orders left: ");
                    mariosActiveOrders.displayActiveOrders();
                    break;
                case 5:
                    System.out.println("yAyEEt");

                    break;
                case 9:
                    System.out.println("Exiting program");
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
