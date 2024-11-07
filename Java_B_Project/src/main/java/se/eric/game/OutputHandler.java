package se.eric.game;

import se.eric.item.Item;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OutputHandler {

    public static Location getOptions(String meseg, Location[] options) {   //Used to print out the options in the living room and get the anser
        String input;
        while(true) {
            printDelay();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(meseg);
            for (int i = 0; i < options.length; i++) {
                System.out.println( "*   " + options[i]);
            }
            input=InputHandler.getStringLowerCas();
            for(Location d:options){
                if (d.toString().equals(input)) {
                    return d;
                }
            }
            for(int i = 0;i< options.length;i++){
                if (input.equals(i+1)) {
                    return options[i];
                }
            }
            System.out.println("invalid input");

        }
    }

    public static void printOptions(String meseg, List<String> options) {       //Used to print out several different options
        printDelay();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(meseg);
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i) != null){
                System.out.println(  "*:   " + options.get(i));
            }
        }
    }

    public static void printDelay()  {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public static void printSurroundings(String room){
        System.out.println("You are in the "+room+", you look around and you see");
    }
}
