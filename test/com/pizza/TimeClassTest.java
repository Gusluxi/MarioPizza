package com.pizza;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeClassTest {

    @Test
    void setTimeOfTheDay() {
        TimeClass tc = new TimeClass();
        LocalTime setTime = LocalTime.of(15,15);
        String timeTest = setTime.toString();
        String timeTest2 = tc.setTimeOfTheDay(15,15);
        assertEquals(timeTest,timeTest2);

    }
}