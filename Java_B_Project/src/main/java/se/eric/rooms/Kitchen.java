package se.eric.rooms;

import se.eric.game.InputHandler;
import se.eric.game.Location;
import se.eric.game.OutputHandler;
import se.eric.item.FryingPan;
import se.eric.item.Item;
import se.eric.item.Knife;
import se.eric.models.Resident;

import java.util.ArrayList;
import java.util.List;

public class Kitchen implements Rooms {

    private String[] places;                            //Saves the sports that items kan be in
    private Item[] items;                               //Saves all the items in the Kitchen
    private Resident resident;                          //The resident is needed to pick upp items
    private List<String> options;

    public Kitchen(Resident resident) {
        places = new String[]{"stow", "counter"};
        items = new Item[]{new FryingPan(), new Knife()};
        this.resident = resident;
        options = new ArrayList<>();                    //List of options

    }

    @Override
    public Location enterRoom() {

        options.clear();                                    //to clear for new options

        for (Item item : items) {
            if (item != null) {                             //Adds all items in the kitchen to the list of options
                options.add("pick up " + item.getName());
            }
        }
        options.add(LEAVE);                           //Adds leave room to options

        surroundings();                                     //Describe the surroundings
        OutputHandler.printOptions("You can: ", options);    //Prints options

        String input = InputHandler.getStringLowerCas();          //Get user input


        if (input.equals(LEAVE.toLowerCase())) {       //Lets user leva the room
            return Location.LIVLINGROOM;
        }
        for (int i = 0; i < items.length; i++) {                  //lets user pick upp item
            if (items[i] != null) {
                if (input.contains(items[i].getName().toLowerCase())) {
                    if (resident.hasItem()) {
                        System.out.println("You picked up " + items[i].getName() + " and leave " + resident.getItem().getName());
                    } else {
                        System.out.println("You picked up " + items[i].getName());
                    }
                    items[i] = resident.switchItem(items[i]);
                    return Location.KITCHEN;
                }
            }
        }
        System.out.println("Sorry, that's not an options");      //In case of wrong input
        return Location.KITCHEN;
    }


    @Override
    public void surroundings() {                        //Describe the surroundings
        OutputHandler.printSurroundings("kitchen");
        for (int i = 0; i < places.length; i++) {
            if (items[i] != null) {
                System.out.println("one the "+places[i]+" there is a "+items[i].getName());
            }
            else
            {
                System.out.println("one the "+places[i]+" there is nothing");
            }
        }
    }
    @Override
    public boolean getboolean(){
        return true;
    }           //Unused butt needed for polymorfism
}
