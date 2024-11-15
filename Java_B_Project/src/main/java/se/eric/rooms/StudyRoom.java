package se.eric.rooms;

import se.eric.game.InputHandler;
import se.eric.game.Location;
import se.eric.game.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class StudyRoom implements Rooms{
    private boolean copsCalled;                         //A variable that remembers where or not the cops have been called or not
    private List<String> options;                       //A list of all option the player has

    public StudyRoom() {
        copsCalled = false;
        options = new ArrayList<>();
    }

    @Override
    public Location enterRoom() {

        options.clear();                                    //to clear for new options

        if (copsCalled) {                                       //if the cops have been called you don't get the option to
            System.out.println("you have called the cops");
        }
        else {
            options.add("call the cops");
        }
        options.add(LEAVE);                                     //adds the option to leave the room

        surroundings();
        OutputHandler.printOptions("you kan", options);     //prints out the surrounding and your options

        String input = InputHandler.getStringLowerCas();          //Get user input

        if(input.equals(options.get(0))&& !copsCalled) {
            System.out.println("you call the cops");                //the player calls the cops
            copsCalled = true;
        }
        else if(input.equals(LEAVE.toLowerCase())) {                    //the player leaves the room
            return Location.LIVLINGROOM;
        }
        else {
            System.out.println("wrong input you stay in the study room"); //if the player does not giv a valid input
        }
        return Location.STUDYROOM;
    }

    @Override
    public void surroundings() {                                  //Describe the surroundings
        OutputHandler.printSurroundings("study");
        System.out.println("one the desk there is a phone");
    }
    @Override
    public boolean getboolean(){                                  //Returns whether the cops have been called or not
        return copsCalled;
    }
}
