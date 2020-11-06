package com.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActiveOrdersTest {

    @Test
    void sortByAttribute() {
        ActiveOrders test = new ActiveOrders();
        ActiveOrders test2 = new ActiveOrders();

        Order order1 = new Order(2,"14:25",1425);
        Order order2 = new Order(3,"15:24",1524);

        test.addOrderToActiveOrders(order2);
        test.addOrderToActiveOrders(order1);
        test.sortByAttribute();
        test2.addOrderToActiveOrders(order1);
        test2.addOrderToActiveOrders(order2);

        assertEquals(test.getActiveOrders(),test2.getActiveOrders());
    }
}