package se.eric.rooms;

import se.eric.game.Location;
import se.eric.game.OutputHandler;
import se.eric.models.Burglar;

public class LivingRoom implements Rooms{
    private Burglar burglar;
    public LivingRoom(Burglar burglar) {                    //instantiate the necessary variabel
        this.burglar = burglar;
    }


    public static Location start(){                         //Start menu
        System.out.println("You wake up on your sofa in the living room. You her sounds from the hallway");
        System.out.println("You look over the sofa and se a person ransacking your hallway. What do you do");
        System.out.println("If you want to finish the game pick quit");
        return OutputHandler.getOptions("you kan go to: ",new Location[] {Location.HALLWAY,Location.BATHROOM,Location.STUDYROOM,Location.KITCHEN,Location.QUIT});
    }

    @Override
    public Location enterRoom() {                           //Returns to the living room
        surroundings();
        return  OutputHandler.getOptions("you kan go to: ",new Location[] {Location.HALLWAY,Location.BATHROOM,Location.STUDYROOM,Location.KITCHEN,Location.QUIT});
    }

    @Override
    public void surroundings() {                            //Describe the living room
        if(burglar.isAlive()) {
            System.out.println("You return to the living room, the thief is still in the Hallway taking more stuff");
        }
        else {
            System.out.println("You return to the living room the thief lies bleeding in the Hallway");
        }
    }
    @Override                                               //Unused butt needed for polymorfism
    public boolean getboolean(){            //Unused butt needed for polymorfism
        return true;
    }
}
