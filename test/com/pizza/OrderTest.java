package com.pizza;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {


    @Test
    void findPizzaNumber() {
    Order order = new Order();
    ArrayList<String> testArray = new ArrayList<>();
    testArray.add("#01. Vesuvio:");
    testArray.add("#05. Dennis:");
    order.setOrder(testArray);

    String expected = "01, 05, ";
    String test = order.findPizzaNumber();
    assertEquals(expected,test);
    }

    @Test
    void convertTimetoTimeInt() {
        Order order = new Order();
        order.setTime("15:25");
        int tested = order.convertTimetoTimeInt(order);
        assertEquals(1525,tested);
    }

}