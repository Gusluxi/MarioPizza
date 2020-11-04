package com.pizza;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeClass {
    static String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

    void displayTime(){
        System.out.println(time);
    }



}
