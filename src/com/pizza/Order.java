package com.pizza;

import java.time.LocalTime;
import java.util.ArrayList;


public class Order implements Comparable<Order> {

    static LocalTime localTime = LocalTime.now();

    private String time;
    private int timeInt;
    private ArrayList<String> order = new ArrayList<String>();
    private int orderID;

    Order(){
    }

    Order(int orderID){
        this.orderID=orderID;
    }
    Order(int orderID, String time,int timeInt){
        this.timeInt=timeInt;
        this.orderID=orderID;
        this.time=time;
    }

    public int getTimeInt(){
        return this.timeInt;
    }

    public void setTimeInt(int timeInt){
        this.timeInt=timeInt;
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

    public int getOrderID(){
        return orderID;
    }

    public void setOrderID(int orderID){
        this.orderID=orderID;
    }

    public ArrayList<String> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<String> order) {
        this.order = order;
    }

    void addPizzaToOrder(String pizzaName){
        order.add(pizzaName);
    }



    void displayCurrentOrder(){
        for (int i=0; i < order.size(); i++){
            System.out.println(order.get(i));
        }
    }

    public String findPizzaNumber() {
        String pizzaNumber = "";
        for (int i = 0; i < order.size(); i++) {
            pizzaNumber += " " + getOrder().get(i).substring(1,3);

        }
        return pizzaNumber;
    }

    @Override
    public String toString() {
        String pizzaNumber = findPizzaNumber();
        return timeInt + "<---Order{" + "Pizzas: ( " + pizzaNumber + "), orderID: #" + orderID + ", time: " + time + '}';
    }

    @Override
    public int compareTo(Order order) {
        int compare = order.getTimeInt();
        return this.timeInt-compare;
    }

    public int convertTimetoTimeInt(Order order){
        String time = order.getTime();
        String timeFixed = time.substring(0,2) + time.substring(3,5);
        int timeInt = Integer.parseInt(timeFixed);
        return timeInt;
    }




}
