package se.eric.item;

public class FryingPan implements Item {

    @Override
    public int getDamage() {            //All FryingPan do 10 damage
        return 10;
    }
    @Override
    public String getName() {           //Macks FryingPan have name frying pan
        return "frying pan";
    }
    @Override
    public String attackTyp(){          //Gets sound that frying pan macks
        return "Stick";
    }
}
