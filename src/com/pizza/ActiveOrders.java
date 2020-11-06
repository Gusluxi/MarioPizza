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
    void printSelectedOrderFromList(int index) {
        System.out.print(activeOrders.get(index) + "\n");;
    }

    public void addOrderToActiveOrders(Order order) {
        this.activeOrders.add(order);
    }
    //addOrderToActivateOrders adder 1 string i stedet for en ArrayList af strings.


    //Denne metode viser index-tallet på ordren i aktive-order-listen. (Bruges i fx i Delete-menuen)
    void indexDisplayActiveOrders(){
        sortByAttribute();
        for (int i = 0; i < activeOrders.size(); i++) {
            String clas = Integer.toString(i+1);
            System.out.println("#" + clas + "  " + activeOrders.get(i));

        }
    }
    //Sorterer ordrer efter attribut (givet i Order class)
    //Skulle den sortere efter andre attributer, skulle vi bruge en Comparator istedet for
    void sortByAttribute(){
        Collections.sort(activeOrders);
    }

}

/*
 void displayActiveOrders(String msg) {
        System.out.println(msg);
        sortByAttribute();
        for (int i = 0; i < activeOrders.size(); i++) {
            System.out.println(activeOrders.get(i));
        }

    }
 */

