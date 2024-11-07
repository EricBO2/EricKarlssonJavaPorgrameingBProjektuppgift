package se.eric.models;

import se.eric.item.Item;

public abstract class Entity {
    private String role;
    private int HP;
    private int baseDamage;
    private Item item;

    public Entity(String role, int HP, int baseDamage) {
        this.role = role;
        this.HP = HP;
        this.baseDamage = baseDamage;
    }

    public void tackDamage(int damage) {
        HP -= damage;
    }

    public Boolean isAlive() {return HP > 0;}

    public void attack(Entity target) {
        if (item != null) {
            target.tackDamage(baseDamage+item.getDamage());
        }
        else
        {
            System.out.println("error no item fond");
            target.tackDamage(baseDamage);
        }
    }
    public void punch(Entity target) {
        target.tackDamage(baseDamage);
    }

    public Item switchItem(Item item) {
        Item tepItem = this.item;
        this.item = item;
        return tepItem;
    }
    public Item getItem() {
        return item;
    }
    public int getHP() {
        return HP;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public int getItemDamage() {
        if (item != null) {
            return baseDamage + item.getDamage();
        }
        else {
            System.out.println(role+ " har inget item");
            return baseDamage;
        }
    }


    public Item getitem(){
        return item;
    }

    public Boolean hasItem() {return item != null;}

    @Override
    public String toString() {return role;}


}
