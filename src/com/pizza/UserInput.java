package com.pizza;

import java.util.Scanner;

public class UserInput {
    static Scanner scan = new Scanner(System.in); //Til inputInt() metode (LAV OGSÅ inputString
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

    //Overloaded inputInt()
    //InputInt validering om det er hel-tal
    public static int inputInt() {
        int number;

        while (!scan.hasNextInt()) {
            System.out.println("Du skal skrive et hel-tal!");
            System.out.println("Indtast nummer: ");
            scan.nextLine();
        }
        number = scan.nextInt();
        return number;
    }

    //Validering om det er heltal samt et minimum og maximum tal.
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
    //Takes a String msg for user and setHour(hourInt) + setMinute(minuteInt). You get min and hour with getters.
    public void inputTimeInt(String msgOutput)  {
        String time;
        int hourInt = -1;
        int minuteInt = -1;
        System.out.println("\n" + msgOutput);
        scan.nextLine();
        do {
            time = scan.nextLine();

            if (time.length() == 5 && (time.contains(":") || time.contains(".") || time.contains(",") || time.contains(" "))) {
                //5Time in 4 numbers and 1 sign, EX. 12:30
                try {
                    hourInt = Integer.parseInt(time.substring(0, 2));
                    minuteInt = Integer.parseInt(time.substring(3, 5));
                } catch (NumberFormatException e) { }
            }

            if (time.length() == 4){
                if (time.contains(":") || time.contains(".") || time.contains(",") || time.contains(" ")) {
                    //4Time in 3 numbers and 1 sign, EX. 9:30
                    try {
                        hourInt = Integer.parseInt(time.substring(0, 1));
                        minuteInt = Integer.parseInt(time.substring(2, 4));
                    } catch (NumberFormatException e) { }
                } else {
                    //4Time in 4 numbers, EX. 1030
                    try {
                        hourInt = Integer.parseInt(time.substring(0, 2));
                        minuteInt = Integer.parseInt(time.substring(2, 4));
                    } catch (NumberFormatException e) { }
                }
            }

            //3Time in 3 numbers, EX. 930
            if (time.length() == 3) {
                try {
                    hourInt = Integer.parseInt(time.substring(0, 1));
                    minuteInt = Integer.parseInt(time.substring(1, 3));
                } catch (NumberFormatException e) { }
            }

            //Error msg
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

    public static String inputString() {
        String word;
        while(!scan.hasNextLine()){
            System.out.println("Du skal skrive en String!");
            System.out.println("Skriv string: ");
            scan.next();
        }
        word = scan.next();
        return word;
    }

}
