package com.pizza;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void testInputInt() {
        int number;
        int testUserInput = 12;
        while (testUserInput != testUserInput) {
            assertNotEquals("Random String", testUserInput);
            assertNotEquals(12.32, testUserInput);
        }
        number = testUserInput;
        assertEquals(number, 12);

    }

    @Test
    void testInputInt1() {
        int number;
        int testUserInput = 12;
        do {
            while (testUserInput != testUserInput) {
                assertNotEquals("Random String", testUserInput);
                assertNotEquals(12.32, testUserInput);
            }
            number = testUserInput;
            assertFalse ((number < 1) || (number > 15));
        } while (number < 1 || number > 15);
        assertEquals(number, 12);
    }

    @Test
    void inputString() {
        String string;
        String testUserInput = "I like cats";
        while (testUserInput != testUserInput) {
            assertNotEquals(12, testUserInput);
            assertNotEquals(12.32, testUserInput);
        }
        string = testUserInput;
        assertEquals(string, "I like cats");
    }
}