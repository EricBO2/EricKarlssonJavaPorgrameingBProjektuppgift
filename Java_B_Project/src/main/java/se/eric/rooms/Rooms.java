package se.eric.rooms;

import se.eric.game.Location;

public interface Rooms {
    Location enterRoom();                       //The main method that runns when the player is in the room

    void surroundings();                          //This method to describe the room

    boolean getboolean();                       //som of the rooms have variabels that is needed outside of class
}
