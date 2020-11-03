package com.pizza;

import java.util.ArrayList;

public class Order {

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
        for (int i=0; i<order.size() ; i++){
            System.out.println(order.get(i));
        }
    }


    @Override
    public String toString() {
        return "Order{" +
                "order=" + order +
                ", orderID=" + orderID +
                ", time='" + time + '\'' +
                '}';
    }
}
