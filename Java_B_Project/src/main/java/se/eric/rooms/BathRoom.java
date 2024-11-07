package se.eric.rooms;

import se.eric.game.InputHandler;
import se.eric.game.Location;

import java.util.ArrayList;
import java.util.List;

import se.eric.game.OutputHandler;
import se.eric.models.*;

public class BathRoom implements Rooms{
    private Burglar burglar;
    private Boolean hide;

    public BathRoom(Burglar burglar){
        this.burglar = burglar;                      //instantiate the necessary variabel
        hide = false;
    }

    @Override
    public Location enterRoom() {
        List<String> option = new ArrayList<>();    //list of options

        if (burglar.isAlive()) {
            option.add("hide in tub");
        }
        option.add("leave room");

        surroundings();                             //Describe the bathroom
        OutputHandler.printOptions("You can: ", option);

        String input = InputHandler.getStringLowerCas();
        if (input.equals("leave room")) {                       //leave room metod
            return Location.LIVLINGROOM;
        }
        if (input.equals("hide in tub")&& burglar.isAlive()) {
            System.out.println("You hide in the tub");           //hide in the tub metod
            hide = true;
            return Location.QUIT;
        }

        return Location.BATHROOM;
    }

    @Override
    public void surroundings() {                                //Describe the bathroom
        OutputHandler.printSurroundings("bathroom");
        System.out.print("there is a bathtub");
        if (burglar.isAlive()){
            System.out.println(" the thief wood probably not lock in there");
        }

    }
    @Override
    public boolean getboolean(){
        return hide;
    }
}
