package se.eric.game;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scan = new Scanner(System.in);

    private InputHandler() {}                           //this howl class is only to mack sure I only need one scanner

    public static String getString(){
        return scan.nextLine();
    }
    public static String getStringLowerCas(){
        return scan.nextLine().toLowerCase();
    }
}
