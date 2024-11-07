package se.eric.game;

import se.eric.models.Burglar;
import se.eric.models.Resident;
import se.eric.rooms.*;

public class Main {

    private static Resident resident;
    private static Burglar burglar;
    private static Location myLocation;
    private static Rooms[] rooms;

    public static void main(String[] args) {
        resident = new Resident("Home owner",50,5);
        burglar = new Burglar("Burglar",50,10);                     //Creates my two Entitys Burglar and Resident

        myLocation = Location.START;                                                //Creates my enum that holds the players location
        rooms = new Rooms[] {new LivingRoom(burglar), new Hallway(burglar,resident),new BathRoom(burglar), new Kitchen(resident), new StudyRoom()};
                                                                                    //Creates an array that holds all my rooms and give them the information that they rekvier

        Game.runGame(myLocation,rooms,resident);                                    //Starts the game and it the information that it rekvier

        Game.quit(resident,burglar,rooms);                                          //Calls the metod that determens and print out the end message

    }
}
