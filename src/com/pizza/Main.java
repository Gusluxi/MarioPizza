package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static ActiveOrders mariosActiveOrders = new ActiveOrders();
    static justAFileClass readFile = new justAFileClass();
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
        int choice = -1;
        String headertext = "MENU:";
        String leadtext = "Please choose:\n";
        String[] menuitems = {"1. View user list", "2. Create new user", "3. Delete user",
                "4. Savefile?","5. Readfile", "9 to quit"};


        while (run){
            Menu menu = new Menu(headertext,leadtext,menuitems);
            menu.printMenu();
            choice = menu.readChoice();

            switch (choice){
                case 1:
                    System.out.println("You chose 1. View user list");

                    break;
                case 2:
                    System.out.println("You chose 2. Create new user");

                    break;
                case 3:
                    System.out.println("You chose 3. Delete user");

                    break;
                case 4:
                    System.out.println("You chose 4. Save file");

                    break;
                case 5:
                    System.out.println("You chose 5. Read file");

                    break;
                case 9:
                    System.out.println("Quitting program");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid number");
            }
        }
    }


    public static void main(String[] args) throws IOException {

        justAFileClass test = new justAFileClass();
        //test.printPizzaMenu();
        test.startNewOrder();
        test.testClass();






        //Main prg = new Main();
        //prg.run();

    }
}
