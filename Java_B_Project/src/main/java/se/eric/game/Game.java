package se.eric.game;

import se.eric.models.Burglar;
import se.eric.models.Resident;
import se.eric.rooms.LivingRoom;
import se.eric.rooms.Rooms;

public class Game {
    public static void runGame(Location myLocation, Rooms[] rooms, Resident resident) {

        while (myLocation != Location.QUIT&&resident.isAlive()) {               //A loop that continues until the player wants to quit or dies
            myLocation=switch (myLocation) {                                    //A switch that uses myLocation to use the right class in rooms
                case START -> LivingRoom.start();

                case LIVLINGROOM ->  rooms[0].enterRoom();

                case HALLWAY -> rooms[1].enterRoom();

                case BATHROOM -> rooms[2].enterRoom();

                case KITCHEN -> rooms[3].enterRoom();

                case STUDYROOM -> rooms[4].enterRoom();

                case QUIT -> Location.QUIT;

            };
        }
    }


    public static void quit(Resident resident, Burglar burglar, Rooms[] rooms){

        if (resident.isAlive()) {                                   //Checks if the resident is alive
            if (burglar.isAlive()) {                                //Checks if the burgaller is alive
                if (rooms[4].getboolean()) {                        //Checks if the cops are called
                    if (rooms[2].getboolean()) {                    //Checks if the resident hid in the bath tub
                        System.out.println("You hide in the bathtub after calling the cops");
                        System.out.println("the burglar continues robing the house until the cops arrive and caught him red-handed");
                        System.out.println("he is arrested and you get your things back");
                        System.out.println("score : 10/10");
                    }
                    else {
                        System.out.println("You were caught by the thief after calling the cops");
                        System.out.println("He nocks you out and takes all he can and runs away. The cops find you on the floor");
                        System.out.println("the thief got away with your stuff but you are alive");
                        System.out.println("score : 6/10");
                    }
                }
                else {
                    if (rooms[2].getboolean()) {
                        System.out.println("You hide in the bath tub");
                        System.out.println("the burglar continues robing your house ");
                        System.out.println("he gets away with all your things");
                        System.out.println("score : 5/10");
                    }
                    else {
                        System.out.println("You get caught by the thief");
                        System.out.println("the thief continues robing you");
                        System.out.println("he gets away whit everything and beats you up");
                        System.out.println("score : 4/10");
                    }
                }
            }
            else {
                if (rooms[4].getboolean()) {
                    System.out.println("You knock out the robber and call the cops");
                    System.out.println("you wait for the cops get here");
                    System.out.println("the cops reprimand you for risking yourself and take away the burglar");
                    System.out.println("score : 8/10");
                }
                else {
                    System.out.println("you knock out the robber");
                    System.out.println("you leave him on the floor and he bleeds out");
                    System.out.println("the cops eventually find out and arrest you for murder");
                    System.out.println("score : 3/10");
                }
            }
        }
        else {
            if (rooms[4].getboolean()) {
                System.out.println("your killed but you called the cops");
                System.out.println("the killer continues taking your stuff until the cops arrive");
                System.out.println("the killer is arrested and you are buried");
                System.out.println("score : 2/10");
            }
            else{
                System.out.println("Your killed ");
                System.out.println("the robber takes everything you have and leave you dead on the floor");
                System.out.println("the cops eventually finds your corps but never the killer ");
                System.out.println("score : 1/10");
            }
        }

    }
}
