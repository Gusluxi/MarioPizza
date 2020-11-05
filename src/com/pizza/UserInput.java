package com.pizza;

import java.util.Scanner;

public class UserInput {

    static Scanner scan = new Scanner(System.in); //Til inputInt() metode (LAV OGSÅ inputString

    //Overloaded inputInt()
    //InputInt validering om det er hel-tal
    public static int inputInt() {
        int number;

        while (!scan.hasNextInt()) {
            System.out.println("Du skal skrive et hel-tal!");
            System.out.println("Indtast menu nummer: ");
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
            System.out.println("Skriv venligst et tal mellem " + min + " og " + max);
            while (!scan.hasNextInt()) {
                System.out.println("Fejl, du skal skrive et tal");
                scan.next(); // this is important!
            }
            number = scan.nextInt();
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
