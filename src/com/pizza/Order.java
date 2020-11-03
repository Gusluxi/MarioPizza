package com.pizza;

import java.util.ArrayList;

public class Order {

    private ArrayList<String> order = new ArrayList<String>();

    Order(){
    }



    void addPizzaToOrder(String pizzaName){
        order.add(pizzaName);
    }

    void displayCurrentOrder(){
        for (int i=0; i<order.size() ; i++){
            System.out.println(order.get(i));
        }
    }

}
