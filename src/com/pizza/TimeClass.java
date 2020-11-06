package com.pizza;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeClass {
    static String currentRealTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

    String displayTime(){
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
        int timeHourSat = UserInput.inputInt(0,23,"Skriv en bestemt time:");
        int timeMinSat = UserInput.inputInt(0,59,"Skriv en bestemt minute:");
        System.out.println(timeHourSat);
        System.out.println(timeMinSat);
        //Assigning values order
        order.setTime(setTimeOfTheDay(timeHourSat, timeMinSat));
        order.setTimeInt(order.convertTimetoTimeInt(order));
    }

}
