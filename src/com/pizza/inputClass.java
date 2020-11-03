package com.pizza;

import java.util.Scanner;

public class inputClass {

    static Scanner scan = new Scanner(System.in); //Til inputInt() metode (LAV OGSÅ inputString

    public static int inputInt() {

        int number = 0;
        while (!scan.hasNextInt()) {
            System.out.println("Du skal skrive et hel-tal!");
            System.out.println("Indtast menu nummer: ");
            scan.nextLine();
        }
        number = scan.nextInt();
        return number;
    }
    public static int inputInt(int min, int max) {
        int number;
        do {
            System.out.println("vælg mellem 1-14");
            while (!scan.hasNextInt()) {
                System.out.println("Fejl du har ikke skrevet et hel-tal mellem " + min + " og " + max);
                scan.next();
            }
            number = scan.nextInt();
        } while ((number >= max) || (number <=min));
        return number;
    }

    public static String inputString() {
        String word;
        while(!scan.hasNextLine()){
            System.out.println("Du skal skrive en String!");
            System.out.println("Skriv string:");
            scan.nextLine();
        }
        word = scan.nextLine();
        return word;
    }

}
