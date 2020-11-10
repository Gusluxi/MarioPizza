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
        String nr7 = "#07. Silvia: tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano........ 61 kr.";
        String nr8 = "#08. Victoria: tomatsauce, ost, skinke, ananas, champignon, løg og oregano........ 61 kr.";
        String nr12 = "#12. Le Blissola: tomatsauce, ost, skinke, rejer og oregano....................... 61 kr.";
        String nr24 = "#24. Mix: tomatsauce, ost, skinke, pepperoni, bacon, paprika, løg, champignon..... 65 kr.";
        String nr33 = "#33. Chorinzo: tomatsauce, ost, chorinzo, rucola, pestodressing................... 63 kr.";

        ArrayList<String> list1 = new ArrayList();
        list1.add(nr33);list1.add(nr4);list1.add(nr1);

        ArrayList<String> list2 = new ArrayList();
        list2.add(nr4);list2.add(nr7);list2.add(nr7);list2.add(nr8);list2.add(nr12);list2.add(nr7);

        ArrayList<String> list3 = new ArrayList();
        list3.add(nr1);list3.add(nr33);

        ArrayList<String> list4 = new ArrayList();
        list4.add(nr33);list4.add(nr4);list4.add(nr8);list4.add(nr12);list4.add(nr24);

        Order order1 = new Order(list1,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(11,45),1145);
        Order order2 = new Order(list2,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(9,45),945);
        Order order3 = new Order(list3,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(9,30),930);
        Order order4 = new Order(list4,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(12,15),1215);
        Order order5 = new Order(list4,miscellaneous.newOrderID(),timeClass.setTimeOfTheDay(18,40),1840);

        mariosActiveOrders.addOrderToActiveOrders(order1);
        mariosActiveOrders.addOrderToActiveOrders(order2);
        mariosActiveOrders.addOrderToActiveOrders(order3);
        mariosActiveOrders.addOrderToActiveOrders(order4);
        mariosActiveOrders.addOrderToActiveOrders(order5);
    }
}
