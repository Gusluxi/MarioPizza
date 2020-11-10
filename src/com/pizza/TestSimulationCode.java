package com.pizza;

import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.ArrayList;

import static com.pizza.EditOrderFile.mariosActiveOrders;

public class TestSimulationCode {
    Miscellaneous miscellaneous = new Miscellaneous();
    TimeClass timeClass = new TimeClass();


    void insertTestSimulatedCode() throws FileNotFoundException {
        String nr1 = "#01. Vesuvio: tomatsauce, ost, skinke og oregano ................................. 57 kr.";
        String nr4 = "#04. Carbona: tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano..... 63 kr.";
        String nr8 = "#08. Victoria: tomatsauce, ost, skinke, ananas, champignon, løg og oregano........ 61 kr.";
        String nr12 = "#12. Le Blissola: tomatsauce, ost, skinke, rejer og oregano....................... 61 kr.";

        ArrayList<String> list1 = new ArrayList();
        list1.add(nr1);list1.add(nr4);list1.add(nr1);

        ArrayList<String> list2 = new ArrayList();
        list2.add(nr1);list2.add(nr4);list2.add(nr8);list2.add(nr12);

        Order order1 = new Order(list1,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(11,45),1145);
        Order order4 = new Order(list2,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(9,45),945);
        Order order2 = new Order(list1,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(9,30),930);
        Order order3 = new Order(list1,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(12,15),1215);

        mariosActiveOrders.addOrderToActiveOrders(order1);
        mariosActiveOrders.addOrderToActiveOrders(order2);
        mariosActiveOrders.addOrderToActiveOrders(order3);
        mariosActiveOrders.addOrderToActiveOrders(order4);
    }
}
