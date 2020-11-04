package com.pizza;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {

    static LocalTime localTime = LocalTime.now();

    private ArrayList<String> order = new ArrayList<String>();
    private int orderID;
    private String time;

    Order(){
    }

    Order(int orderID){
        this.orderID=orderID;

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

    void ManualAddPizzaToOrder(String pizzaName){
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
            pizzaNumber += " " + getOrder().get(i).substring(0,3);

        }
        return pizzaNumber;
    }

    @Override
    public String toString() {
        String pizzaNumber = findPizzaNumber();
        return "Order{" + "order = " + pizzaNumber + ", orderID = " + orderID + ", time = '" + time + '\'' + '}';
    }

    public void setTime(String time) {
        this.time = time;
    }
}
