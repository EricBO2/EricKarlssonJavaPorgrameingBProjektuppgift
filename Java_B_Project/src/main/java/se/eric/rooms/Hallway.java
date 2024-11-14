package se.eric.rooms;

import se.eric.game.InputHandler;
import se.eric.game.Location;
import se.eric.game.OutputHandler;
import se.eric.models.Burglar;
import se.eric.models.Resident;

import java.util.ArrayList;
import java.util.List;

public class Hallway implements Rooms {
    private Burglar burglar;
    private Resident resident;
    private List<String> options;

    public Hallway(Burglar burglar, Resident resident) {
        this.burglar = burglar;                             //Instantiate the necessary variabel
        this.resident = resident;
        this.options = new ArrayList<>();                   //Array white all options

    }

    @Override
    public Location enterRoom() {

        surroundings();                                     //Describe the Hallway

        options.clear();                                    //to clear for new options
        while (burglar.isAlive() && resident.isAlive()) {
            options.clear();
            options.add("Punch");
            if (resident.hasItem()) {                       //Puts the options the user have in the lis
                options.add(resident.getItem().attackTyp());
            }
            else{
                options.add(null);
            }

            OutputHandler.printOptions("you kan ", options);
            String input = InputHandler.getStringLowerCas();        //prints the options and get a respons


            if (input.equals(options.get(0).toLowerCase())) {       //punch metod
                System.out.println(resident.toString() + " punches " + burglar.toString());
                resident.punch(burglar);
                if (burglar.isAlive()) {
                    System.out.println(burglar.toString() + " punches " + resident.toString());
                    burglar.punch(resident);
                    System.out.println("the "+burglar.toString()+" is still attacking");
                } else {
                    System.out.println("you nock out the burglar");
                }                                                   //use tool metond
            } else if (options.get(1)!=null&&input.equals(options.get(1).toLowerCase())) {
                System.out.println(resident.toString() + " " + resident.getItem().attackTyp() + " " + burglar.toString());
                resident.attack(burglar);
                if (burglar.isAlive()) {
                    System.out.println(burglar.toString() + " punches " + resident.toString());
                    burglar.punch(resident);
                } else {
                    System.out.println("you nock out the burglar");
                }
            } else {                                                //in case of user error
                System.out.println("invalid input you stand there looking dum");
            }
        }
        if ( resident.isAlive()) {                                  //Menu if burgaller is uncations

            options.clear();
            options.add("Quit");
            options.add(LEAVE);
            OutputHandler.printOptions("you kan", options);
            String input = InputHandler.getStringLowerCas();
            if (input.equals(LEAVE.toLowerCase())) {
                return Location.LIVLINGROOM;
            }
            if (input.equals("quit")) {
                return Location.QUIT;
            }
        }
        return Location.HALLWAY;

    }

    @Override
    public void surroundings() {                                //Describe the Hallway
        System.out.println("You enter the hallway your things are scatter everywhere ");
        if (burglar.isAlive()) {
            System.out.println("then the robber finally notis you and gets ready to fight ");
        } else {
            System.out.println("the robber lies unconscious on the floor");
        }
    }

    @Override                               //Unused butt needed for polymorfism
    public boolean getboolean() {
        return true;
    }
}
