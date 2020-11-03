package com.pizza;

import java.util.ArrayList;

public class Order {

    private ArrayList<String> order = new ArrayList<String>();

    Order(){
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

}
