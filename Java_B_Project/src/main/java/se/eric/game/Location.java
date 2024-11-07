package se.eric.game;

public enum Location {
    BATHROOM("bathroom"),                           //Used as a variable to keep track of where the player is
    HALLWAY("hallway"),
    KITCHEN("kitchen"),
    LIVLINGROOM("livingroom"),
    STUDYROOM("studyroom"),
    START("start"),
    QUIT("quit");


    private final String description;

    Location (String description) {
        this.description= description;
    }

    @Override
    public String toString() {
        return description;
    }       //Used to easily get the location as a string


}
