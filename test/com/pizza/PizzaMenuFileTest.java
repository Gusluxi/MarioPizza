package com.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaMenuFileTest {

    @Test
    void findAndAddToOrder() {
        int inputPizzaInt = 12;
        String inputPizzaString = Integer.toString(inputPizzaInt);
        inputPizzaString += ".";
        String lineFromText = "#12. Le Blissola: tomatsauce, ost, skinke, rejer og oregano.................... 61 DKK";
        if (lineFromText.contains(inputPizzaString))
            inputPizzaString = lineFromText;

        assertEquals(lineFromText, inputPizzaString);
    }
}