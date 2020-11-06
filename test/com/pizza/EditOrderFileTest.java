package com.pizza;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EditOrderFileTest {

    @Test
    void startNewOrder() throws FileNotFoundException {
        ActiveOrders mariosActiveOrders = new ActiveOrders();
        ActiveOrders mariosActiveOrders2 = new ActiveOrders();
        Order order1 = new Order(1,"15:15",1515);

        Order methodOrder = new Order();
        //GENERATE ORDER ID
        methodOrder.setOrderID(1);

        //SET TIME FOR PICKUP
        methodOrder.setTime("15:15");
        methodOrder.setTimeInt(1515);

        String test = order1.toString();
        String test2 = methodOrder.toString();

        assertEquals(test,test2);

        //SEND TO ACTIVE ORDERS
        String lengthTest = mariosActiveOrders2.getActiveOrders().toString()+""; //"" for at sætte noget ind i stringen..
                                                //Hvis addOrder metoden ikke virker, så er lengthtest'ene det samme
        mariosActiveOrders.addOrderToActiveOrders(methodOrder);
        String lengthTest2 = mariosActiveOrders.getActiveOrders().toString()+"";
        assertNotEquals(lengthTest2,lengthTest);

    }

    @Test
    void confirmOrderSold() throws IOException {
        File PitzHistoric = new File("src\\com\\pizza\\PitzHistoric.txt");
        FileWriter fw = new FileWriter(PitzHistoric,true);
        Order order = new Order(123,"15:14",1514);
        double length = PitzHistoric.length();

        fw.write(order.toString());
        fw.write("\n");
        fw.close();

        double length2 = PitzHistoric.length();
        assertNotEquals(length,length2);
    }
}