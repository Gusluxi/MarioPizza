package com.pizza;

import java.util.ArrayList;
import java.util.Collections;

public class ActiveOrders {


    private ArrayList<Order> activeOrders = new ArrayList<>();

    ActiveOrders() {
    }

    //Get og set
    public ArrayList<Order> getActiveOrders() {
        return activeOrders;
    }

    public void setActiveOrders(ArrayList<Order> activeOrders) {
        this.activeOrders = activeOrders;
    }
    //

    void RemoveOrderFromList() {
        activeOrders.remove(0);
    }

    void manualRemoveOrderFromList(int orderNumber) {
        activeOrders.remove(orderNumber);
    }

    public void addOrderToActiveOrders(Order order) {
        this.activeOrders.add(order);
    }
    //addOrderToActivateOrders adder 1 string i stedet for en ArrayList af strings.

    void displayActiveOrders() {
        for (int i = 0; i < activeOrders.size(); i++) {
            System.out.println(activeOrders.get(i));
        }

    }

    void sortByAttribute(){
        Collections.sort(activeOrders);
        for (Order order:activeOrders){
            System.out.println(order.toString());
        }
    }


}


/*
    void sortByAttribute(ActiveOrders activeOrderList) {
        for (int i = 0; i < activeOrders.size(); i++) {
            Collections.sort(activeOrders, Collections.reverseOrder());
        }
    }

 */


