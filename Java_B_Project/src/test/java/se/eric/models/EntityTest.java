package se.eric.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.eric.item.FryingPan;

class EntityTest {
     Resident resident;
     Burglar burglar;

    @BeforeEach
     void setUp() {
        resident = new Resident("resident", 50, 5);
        burglar = new Burglar("Burglar", 50, 10);
    }

    @Test
    void testTackDamage() {
        int maxHP = resident.getHP();
        resident.tackDamage(5);

        Assertions.assertEquals(maxHP - 5, resident.getHP());
    }

    @Test
    void isAlive() {
        resident.tackDamage(10);

        Assertions.assertTrue(resident.isAlive());
    }

    @Test
    void isDead() {
        resident.tackDamage(100);
        Assertions.assertFalse(resident.isAlive());
    }

    @Test
    void attack() {
        int maxHP = resident.getHP();
        burglar.switchItem(new FryingPan());
        burglar.attack(resident);
        Assertions.assertEquals(maxHP - burglar.getItemDamage(), resident.getHP());
    }

    @Test
    void punch() {
        int maxHP = resident.getHP();
        burglar.punch(resident);
        Assertions.assertEquals(resident.getHP(), maxHP - burglar.getBaseDamage());

    }
}