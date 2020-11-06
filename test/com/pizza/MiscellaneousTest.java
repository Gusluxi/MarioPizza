package com.pizza;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MiscellaneousTest {

    @Test
    void readOrderID() throws FileNotFoundException {
        Scanner iDFileScan = new Scanner(new File("src\\com\\pizza\\OrderID.txt"));
        String stringID = iDFileScan.nextLine();
        int intID = Integer.parseInt(stringID);
        assertEquals(748, intID);
    }
}