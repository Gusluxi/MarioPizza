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

    void RemoveOrderFromList(){
        activeOrders.remove(0);
    }
    void manualRemoveOrderFromList(int orderNumber){
        activeOrders.remove(orderNumber);
    }

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
