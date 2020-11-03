package com.pizza;

import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;


    public Menu(String menuHeader, String leadText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }

    public void printMenu() {
        String printString = menuHeader + "\n";

        for (int i = 0; i < menuItems.length; i++)
            printString += menuItems[i] + "\n";
        System.out.println("\n" + printString);
    }

    public int readChoice() {
        Scanner scanner = new Scanner(System.in);
        boolean validChoice = false;
        int choice = -1;

        while (! validChoice) {
            System.out.print(leadText);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                validChoice = true;
            } else {
                scanner.nextLine();
            }
        }
        return choice;
    }

}
