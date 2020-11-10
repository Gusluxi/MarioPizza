package com.pizza;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//Arraylist, Collections, List, Scanner, File, IOException, FileWriter, PrintWriter

public class Order implements Comparable<Order> {
    static File soldPizzas2 = new File("src\\com\\pizza\\PitzHistoric2.txt");

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

    
    //Displays orders in the menu
    void displayCurrentOrder(String msg) {
        sortByAttribute();
        System.out.println(msg);
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }
    }

    //Method used to make a cleaner toString, for displaying orders.
    public String findPizzaNumber() {
        String pizzaNumber = "";
        for (int i = 0; i < order.size(); i++) {
            pizzaNumber += getOrder().get(i).substring(1, 3) + ", ";

        }
        return pizzaNumber;
    }

    //Used solely in statistics, does the same as the method above.
    public String findPizzaNumber2() {
        String pizzaNumber = "";
        for (int i = 0; i < order.size(); i++) {
            pizzaNumber += getOrder().get(i).substring(1, 3) + " ";

        }
        return pizzaNumber;
    }

    //toString...
    @Override
    public String toString() {
        String pizzaNumber = findPizzaNumber();
        return "Order: #" + orderID + " - Afhentning kl. " + time + " - Pizza nr. ( " + pizzaNumber + ")";
        //return "Order{" + "Pizzas: ( " + pizzaNumber + "), orderID: #" + orderID + ", time: " + time + '}'; //tilføj evt. " timeInt + "<--- " foran Order for at se tids-atribut
    }

    //toString for statistics.
    public String statsToString() {
        String pizzaNumber2 = findPizzaNumber2();
        return pizzaNumber2 ;
        }


    //Changes how Collections.sort works on our Order-objects.
    //It now sorts by a "semi-hidden" attribute called timeInt
    @Override
    public int compareTo(Order order) {
        int compare = order.getTimeInt();
        return this.timeInt - compare;
    }

    //Converts our time-attribute to an Integer as assigns the value to our order.
    public int convertTimetoTimeInt(Order order) {
        String time = order.getTime();
        String timeFixed = time.substring(0, 2) + time.substring(3, 5);
        int timeInt = Integer.parseInt(timeFixed);
        return timeInt;
    }

    //Sorts the order, uses Comparable, (see compareTo method)
    void sortByAttribute() {
        Collections.sort(order);
    }

    //Used to sort information stored in our file for completed purchases.
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
