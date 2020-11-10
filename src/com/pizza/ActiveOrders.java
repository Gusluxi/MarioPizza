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

    void removeOrderFromList(int index) {
        activeOrders.remove(index);
    }
    void printSelectedOrderFromList(int index) {
        System.out.print(activeOrders.get(index) + "\n");;
    }

    public void addOrderToActiveOrders(Order order) {
        this.activeOrders.add(order);
    }


    //Shows the indexnumber of active numbers in displayed menus.
    void indexDisplayActiveOrders(String msgToUser){
        System.out.println(msgToUser);
        sortByAttribute();
        for (int i = 0; i < activeOrders.size(); i++) {
            String clas = Integer.toString(i+1);
            System.out.println("#" + clas + "  " + activeOrders.get(i));

        }
    }
    void indexPriceDisplayActiveOrders(String msgToUser){
        System.out.println(msgToUser);
        sortByAttribute();
        for (int i = 0; i < activeOrders.size(); i++) {
            String clas = Integer.toString(i+1);
            System.out.println("#" + clas + "  " + activeOrders.get(i).toStringWithPrice());

        }
    }

    //Used to sort orders by attribute. (Comparator used in case we need to sort by more than one thing
    void sortByAttribute(){
        Collections.sort(activeOrders);
    }

}


