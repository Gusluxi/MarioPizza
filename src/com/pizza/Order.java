package com.pizza;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;


public class Order implements Comparable<Order> {

    static LocalTime localTime = LocalTime.now();

    private String time;
    private int timeInt;
    private ArrayList<String> order = new ArrayList<>();
    private int orderID;

    Order() {
    }

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

    public static void setLocalTime(LocalTime localTime) {
        Order.localTime = localTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOrderID() {
        return orderID;
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

    void removePizzaFromOrder(String pizzaName) {order.remove(pizzaName);}

    
    //Metode navnet siger det
    void displayCurrentOrder(String msg) {
        sortByAttribute();
        System.out.println(msg);
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }
    }

    //Denne metode afleverer Pizzanummeret istedet for hele navnet, som vi bruger i toString().
    public String findPizzaNumber() {
        String pizzaNumber = "";
        for (int i = 0; i < order.size(); i++) {
            pizzaNumber += getOrder().get(i).substring(1, 3) + ", ";

        }
        return pizzaNumber;
    }

    @Override
    public String toString() {
        String pizzaNumber = findPizzaNumber();
        return "Order{" + "Pizzas: ( " + pizzaNumber + "), orderID: #" + orderID + ", time: " + time + '}'; //tilføj evt. " timeInt + "<--- " foran Order for at se tids-atribut
    }


    @Override //vigtig metode til at sortere vores Ordrer efter tids-elementet i dem. Bruges i sortByAttribute()
    //Hvis rækkefølgen skal ændres, så byt om på this.timeInt og compare

    public int compareTo(Order order) {
        int compare = order.getTimeInt();
        return this.timeInt - compare;
    }

    //Konverterer tids-attributen til en int, og assigner den til ordren. Så kan vi nemmere sortere.
    public int convertTimetoTimeInt(Order order) {
        String time = order.getTime();
        String timeFixed = time.substring(0, 2) + time.substring(3, 5);
        int timeInt = Integer.parseInt(timeFixed);
        return timeInt;
    }

    //Den sorterer :)
    void sortByAttribute() {
        Collections.sort(order);
    }
}
