package se.eric.item;

public class Knife implements Item {
    @Override
    public int getDamage() {             //All FryingPan do 10 damage
        return 20;
    }

    @Override
    public String getName() {            //Macks Knife have name knife
        return "knife";
    }

    @Override
    public String attackTyp() {          //Gets sound that Knife macks
        return "Stab";
    }
}
