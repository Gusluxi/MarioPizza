package com.pizza;

import java.util.ArrayList;

public class ActiveOrders {

    private ArrayList<Order> activeOrders = new ArrayList<>();

    ActiveOrders(){
    }


    public void addOrderToActiveOrders(Order order) {
        this.activeOrders.add(order);
    }


}
