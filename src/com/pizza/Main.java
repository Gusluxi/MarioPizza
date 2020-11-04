package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static ActiveOrders mariosActiveOrders = new ActiveOrders();
    static PizzaMenuFile readFile = new PizzaMenuFile();
    static File menuTextFile = new File("src\\com\\pizza\\PizzaMenu.txt");
    static Scanner menuList;
    {
        try {
            menuList = new Scanner(menuTextFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    void run() throws IOException { // MENU
        boolean run = true;
        int choice;
        String headertext = "Order Menu:";
        String leadtext = "Vaelg en mulighed: ";
        String[] menuitems = {"1. Ny order", "2. Rediger order", "3. Delete order",
                "4. Save order","5. Se aktive ordrer", "9. Exit program"};


        while (run){
            Menu menu = new Menu(headertext,leadtext,menuitems);
            menu.printMenu();
            choice = UserInput.inputInt(leadtext);

            switch (choice){
                case 1:
                    System.out.println("Ny Order");

                    break;
                case 2:
                    System.out.println("Edit order");

                    break;
                case 3:
                    System.out.println("Delete order");

                    break;
                case 4:
                    System.out.println("Save order");

                    break;
                case 5:
                    System.out.println("Se aktive orders");

                    break;
                case 9:
                    System.out.println("Exiting program");
                    run = false;
                    break;
                default:
                    System.out.println("Forkert valg: ");
            }
        }
    }


    public static void main(String[] args) throws IOException {


        EditOrderFile testEO = new EditOrderFile();
        Miscellaneous testMisc = new Miscellaneous();
        PizzaMenuFile.printPizzaMenu();
        testEO.startNewOrder();
        testEO.testClass();
        testMisc.newOrderID();


        //Main prg = new Main();
        //prg.run();

    }
}
