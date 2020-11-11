package com.pizza;

//Just the menu class :)

public class Menu {
    private final String menuHeader;
    private final String leadText;
    private final String[] menuItems;


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
}
