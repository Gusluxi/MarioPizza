package com.pizza;

import java.util.Scanner;

/**
 * The UserInput class' main purpose is to make sure the user inputs valid numbers/strings.
 */

public class UserInput {
    static Scanner scan = new Scanner(System.in);
    private int hour;
    private int minute;

    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }


    //Checks if the input is an integer and if it is within the chosen min/max value
    public static int inputInt(int min, int max, String msg) {
        int number;
        System.out.println(msg);
        do {

            while (!scan.hasNextInt()) {
                System.out.println("Fejl, du skal skrive et tal:");
                scan.next();
                }
            number = scan.nextInt();
            if (number < min || number > max) {
                System.out.println("Du skal skrive et tal mellem " + min + " og " + max + ":");
            }
        } while (number < min || number > max);

        return number;
    }
    //Asks user to input an integer if they didn't
    public static int inputInt(String msgOutput) {
        int number;
        System.out.println(msgOutput);
        while (!scan.hasNextInt()) {
            System.out.println("Du skal skrive et hel-tal!");
            System.out.println(msgOutput);
            scan.next();
        }
        number = scan.nextInt();
        return number;
    }

    /**
     * Takes a String msg from the user and setHour(hourInt) + setMinute(minuteInt). You get min and hour with getters.
     * Checks the input for certain input such as :.,
     * @param msgOutput is a string from Admin
     */
    public void inputTimeInt(String msgOutput)  {
        String time;
        int hourInt = -1;
        int minuteInt = -1;
        System.out.println("\n" + msgOutput);
        scan.nextLine();

        do {
            time = scan.nextLine();
            final boolean timeContains = time.contains(":") || time.contains(".") || time.contains(",") || time.contains(" ");

            if (time.length() == 5 && timeContains) {
                //5Time in 4 numbers and 1 sign, EX. 12:30
                try {
                    hourInt = Integer.parseInt(time.substring(0, 2));
                    minuteInt = Integer.parseInt(time.substring(3, 5));
                } catch (NumberFormatException e) {
                    System.out.println(e + ". Input Error");
                }
            }

            if (time.length() == 4){
                if (timeContains) {
                    //4Time in 3 numbers and 1 sign, EX. 9:30
                    try {
                        hourInt = Integer.parseInt(time.substring(0, 1));
                        minuteInt = Integer.parseInt(time.substring(2, 4));
                    } catch (NumberFormatException e) {
                        System.out.println(e + ". Input Error");
                    }
                } else {
                    //4Time in 4 numbers, EX. 1030
                    try {
                        hourInt = Integer.parseInt(time.substring(0, 2));
                        minuteInt = Integer.parseInt(time.substring(2, 4));
                    } catch (NumberFormatException e) {
                        System.out.println(e + ". Input Error");
                    }
                }
            }

            //3Time in 3 numbers, EX. 930
            if (time.length() == 3) {
                try {
                    hourInt = Integer.parseInt(time.substring(0, 1));
                    minuteInt = Integer.parseInt(time.substring(1, 3));
                } catch (NumberFormatException e) {
                    System.out.println(e + ". Input Error");
                }
            }

            //Error message
            if ((hourInt < 0 || hourInt > 23) && (minuteInt < 0 || minuteInt > 59))
                System.out.println("Fejl, \"" + time + "\" er ikke et tidspunkt.\n" + msgOutput);
            else {
                if (hourInt < 0 || hourInt > 23)
                    System.out.println("Du skal skrive et time-tal mellem 00 og 23:");
                if (minuteInt < 0 || minuteInt > 59)
                    System.out.println("Du skal skrive et minut-tal mellem 00 og 59:");
            }

        } while ((hourInt < 0 || hourInt > 23) || (minuteInt < 0 || minuteInt > 59));
        setHour(hourInt);
        setMinute(minuteInt);
    }


}
