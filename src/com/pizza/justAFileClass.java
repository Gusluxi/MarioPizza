package com.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class justAFileClass {

    static File menuTextFile = new File("C:\\Users\\M_Joh\\IdeaProjects\\Marios\\src\\com\\pizza\\PizzaMenu.txt");


        //Vi læser i teksten og beder den finde et input vi giver
        //Derefter printer vi linjen i konsol.. Det skal sendes til Display i fremtiden.

        public void readFileClass() throws FileNotFoundException {
            Scanner menuList = new Scanner(menuTextFile);

            System.out.println("Skriv nummer på pizza! (#nummer.)");
            String input = inputClass.inputString();

            while (menuList.hasNextLine()) {
                String lineFromText = menuList.nextLine();
                if (lineFromText.contains(input)) {
                   System.out.println(lineFromText);
                }
            }
            //DEBUG
            System.out.println("length returns:" + menuTextFile.length());
        }


    }

