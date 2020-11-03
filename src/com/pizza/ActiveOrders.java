package com.pizza;

import java.util.ArrayList;

public class ActiveOrders {


    private ArrayList<Order> activeOrders = new ArrayList<>();

    ActiveOrders(){
    }
//
    public ArrayList<Order> getActiveOrders() {
        return activeOrders;
    }

    public void setActiveOrders(ArrayList<Order> activeOrders) {
        this.activeOrders = activeOrders;
    }
//

    public void addOrderToActiveOrders(Order order) {
        this.activeOrders.add(order);
    }

    void displayActiveOrders(){
        for (int i = 0; i<activeOrders.size(); i++){
            System.out.println(activeOrders.get(i));
        }

    }

}








   /* public String toString(){
        getActiveOrders();
        String al = getActiveOrders().toString();
        return "Active orders: "+ al;
    }

    */
