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

    void removeOrderFromList(int index) {
        activeOrders.remove(index);
    }

    public void addOrderToActiveOrders(Order order) {
        this.activeOrders.add(order);
    }
    //addOrderToActivateOrders adder 1 string i stedet for en ArrayList af strings.

    void displayActiveOrders() {
        sortByAttribute();
        for (int i = 0; i < activeOrders.size(); i++) {
            System.out.println(activeOrders.get(i));
        }

    }

    void deleteDisplayActiveOrders(){
        sortByAttribute();
        for (int i = 0; i < activeOrders.size(); i++) {
            String clas = Integer.toString(i+1);
            System.out.println("#" + clas + "  " + activeOrders.get(i));

        }
    }

    void sortByAttribute(){
        Collections.sort(activeOrders);
    }

}



