package com.pizza;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//Arraylist, Collections, List, Scanner, File, IOException, FileWriter, PrintWriter (Written in case of java.io.*)

/**
 * The Order Class has methods to get/set specific attributes,
 * how to sort them and display the right things at the right time
 * The class reads/writes in files.
 */

public class Order implements Comparable<Order> {
    static File soldPizzas2 = new File("src\\com\\pizza\\PitzHistoricNr.txt");

    private String time;
    private int timeInt;
    private ArrayList<String> order = new ArrayList<>();
    private int orderID;

    Order() {}

    Order(int orderID) {
        this.orderID = orderID;
    }

    Order(int orderID, String time, int timeInt){
        this.timeInt = timeInt;
        this.orderID = orderID;
        this.time = time;
    }

    Order(ArrayList<String> order, int orderID, String time, int timeInt) {
        this.order=order;
        this.timeInt = timeInt;
        this.orderID = orderID;
        this.time = time;
    }

    public int getTimeInt() {
        return this.timeInt;
    }

    public void setTimeInt(int timeInt) {
        this.timeInt = timeInt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ArrayList<String> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<String> order) {
        this.order = order;
    }

    void addPizzaToOrder(String pizzaName) {
        order.add(pizzaName);
    }

    void removePizzaFromOrder(String pizzaName) {
        order.remove(pizzaName);
    }


    /**
     * Displays orders in the menu
     * @param msg is a message from the admin
     */
    void displayCurrentOrder(String msg) {
        sortByAttribute();
        System.out.println(msg);
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }
    }

    /**
     * Method used to make a cleaner toString, for displaying orders.
     * @return a string based of another string
     */
    public String findPizzaNumber() {
        String pizzaNumber = "";
        for (int i = 0; i < order.size(); i++) {
            pizzaNumber += getOrder().get(i).substring(1, 3) + ", ";

        }
        return pizzaNumber;
    }

    /**
     * Used solely in statistics, does the same as the method above.
     * @return a string based of another string
     */
    public String findPizzaNumberForStats() {
        String pizzaNumber = "";
        for (int i = 0; i < order.size(); i++) {
            pizzaNumber += getOrder().get(i).substring(1, 3) + " ";

        }
        return pizzaNumber;
    }

    /**
     * Convert price from each pizza to int and calculate total price.
     * @return the price-sum of the order
     */
    public int findTotalPizzaPrice() {
        String pizzaPrice;
        int totalCost = 0;
        for (int i = 0; i < order.size(); i++) {
            pizzaPrice = getOrder().get(i).substring(83, 85);
            totalCost += Integer.parseInt(pizzaPrice);
        }
        return totalCost;
    }

    @Override
    public String toString() {
        String pizzaNumber = findPizzaNumber();
        return "Order: #" + orderID + " - Afhentning kl. " + time + " - Pizza nr. ( " + pizzaNumber + ") ";
    }

    /**
     * toString with price
     * @return toString
     */
    public String toStringWithPrice() {
        String pizzaNumber = findPizzaNumber();
        int totalPrice = findTotalPizzaPrice();
        return "Order: #" + orderID + " - Afhentning kl. " + time + " - TOTAL " + totalPrice + ".00 kr. - Pizza nr. ( " + pizzaNumber + ") ";
    }

    /**
     * toString for statistics (pizza nr.).
     * @return toString
     */
    public String pizzaNumberToString() {
        String pizzaNumber2 = findPizzaNumberForStats();
        return pizzaNumber2 ;
    }

    /**
     * toString for statistics (price).
     * @return toString
     */
    public String priceStatsToString() {
        int priceInt = findTotalPizzaPrice();
        String priceString = Integer.toString(priceInt);
        return priceString;
    }

    /**
     * Changes how Collections.sort works on our Order-objects.
     * It now sorts by a "semi-hidden" attribute called timeInt
     * @param order any given order
     * @return the correct way to sort by
     */
    @Override
    public int compareTo(Order order) {
        int compare = order.getTimeInt();
        return this.timeInt - compare;
    }

    /**
     * Converts our time-attribute to an Integer as assigns the value to our order.
     * @param order any given order
     * @return the time-attribute as an int
     */
    public int convertTimetoTimeInt(Order order) {
        String time = order.getTime();
        String timeFixed = time.substring(0, 2) + time.substring(3, 5);
        int timeInt = Integer.parseInt(timeFixed);
        return timeInt;
    }

    /**
     * Sorts the order, uses Comparable, (see compareTo method)
     */
    void sortByAttribute() {
        Collections.sort(order);
    }


    /**
     * Used to sort information stored in our file for completed purchases.
     * @throws IOException if file cant be found
     */
    void sortFileAlphabetically() throws IOException {

        Scanner readFile = new Scanner(soldPizzas2);

        String inputLine;
        List<String> lineList = new ArrayList<>();
        while (readFile.hasNext()) {
            inputLine = readFile.next();
            lineList.add(inputLine);
        }

        Collections.sort(lineList);

        FileWriter fileWriter = new FileWriter(soldPizzas2);
        PrintWriter out = new PrintWriter(fileWriter);
        for (String outputLine : lineList) {
            out.println(outputLine);
        }
        out.flush();
        out.close();
        fileWriter.close();
    }
}
