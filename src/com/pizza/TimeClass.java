package com.pizza;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * TimeClass main purpose is to return current time and a custom time set by the user
 * this class will be useful for the user to view current time of all the orders and
 * to help the user create a custom time.
 */
public class TimeClass {
    static String currentRealTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    static UserInput userInput = new UserInput();

    /**
     * @return a formatted String of the current time in (Hours:minutes)
     */
    public String displayTime(){
        return currentRealTime;
    }


    /**
     * Uses the localTime utility Java provides of only hours and minutes.
     * The method's parameters will be used to set a custom time.
     * @param hours     Input of hours for when order is ready.
     * @param min       Input of minutes for when order is ready.
     * @return a String after hour-minute input
     */
    public String setTimeOfTheDay(int hours, int min) {
        LocalTime setTime = LocalTime.of(hours,min);
        String timeTest = setTime.toString();
        return timeTest;
    }



    /**
     * This method asks the user to insert a time attribute for an order.
     * The method uses input via UserInput class to assign values to hours and to
     * minutes as well as validating a set parameters and if it is an integer.
     * @param order     The object of the current ArrayList of order.
     */
    public void askForTime(Order order){
        //Ask for input, then assign value to timer
        userInput.inputTimeInt("Skriv en tid i timer og minutter: ");
        int timeHourSat = userInput.getHour();
        int timeMinSat = userInput.getMinute();

        System.out.println("Tid sat til kl. " + timeHourSat + ":" + timeMinSat);
        //Assigning values order
        order.setTime(setTimeOfTheDay(timeHourSat, timeMinSat));
        order.setTimeInt(order.convertTimetoTimeInt(order));
    }

}
