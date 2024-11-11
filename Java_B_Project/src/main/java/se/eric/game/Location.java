package se.eric.game;

public enum Location {
    BATHROOM("Bathroom"),                           //Used as a variable to keep track of where the player is
    HALLWAY("Hallway"),
    KITCHEN("Kitchen"),
    LIVLINGROOM("Livingroom"),
    STUDYROOM("Studyroom"),
    START("Start"),
    QUIT("Quit");


    private final String description;

    Location (String description) {
        this.description= description;
    }

    @Override
    public String toString() {
        return description;
    }       //Used to easily get the location as a string


}
