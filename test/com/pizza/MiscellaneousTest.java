package com.pizza;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MiscellaneousTest {

    @Test
    void readOrderID() {
        String stringID = "669";
        assertEquals("669", stringID);
        int intID = Integer.parseInt(stringID);
        assertEquals(669, intID);
    }

    @Test
    void generateOrderID() {
    }

    @Test
    void newOrderID() {
    }
}