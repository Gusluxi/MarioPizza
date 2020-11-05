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

    void askForTime(Order order){
        //Ask for input, then assign value to timer
        System.out.println("Enter time of completion. Start with hours:");
        int timeHourSat = UserInput.inputInt(0,23,"Must be a valid time! HOUR");
        System.out.println("Enter minutes:");
        int timeMinSat = UserInput.inputInt(0,59,"YAyeetFejl i indtastning MINUT");
        System.out.println(timeHourSat);
        System.out.println(timeMinSat);
        //Assigning values order
        order.setTime(setTimeOfTheDay(timeHourSat, timeMinSat));
        order.setTimeInt(order.convertTimetoTimeInt(order));
    }

}
