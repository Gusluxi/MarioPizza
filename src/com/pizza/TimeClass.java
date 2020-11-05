package com.pizza;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeClass {
    static String currentRealTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmm"));

    String displayTime(){
        System.out.println(currentRealTime);
        return currentRealTime;
    }

    void displayInputTime(String time){
        System.out.println(time);
    }

    String setTimeOfTheDay(int hours, int min) {
        LocalTime setTime = LocalTime.of(hours,min);
        String timeTest = setTime.toString();
        return timeTest;
    }


}
