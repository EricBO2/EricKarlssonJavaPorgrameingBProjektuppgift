package se.eric.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.eric.item.FryingPan;

class EntityTest {
    static Resident R;
    static Burglar B;

    @BeforeEach
    void setUp() {
        R = new Resident("resident", 50, 5);
        B = new Burglar("Burglar", 50, 10);
    }

    @Test
    void testTackDamage() {
        int maxHP = R.getHP();
        R.tackDamage(5);

        Assertions.assertEquals(R.getHP(), maxHP - 5);
    }

    @Test
    void isAlive() {
        R.tackDamage(10);

        Assertions.assertTrue(R.isAlive());
    }

    @Test
    void isDead() {
        R.tackDamage(100);
        Assertions.assertFalse(R.isAlive());
    }

    @Test
    void attack() {
        int maxHP = R.getHP();
        B.switchItem(new FryingPan());
        B.attack(R);
        Assertions.assertEquals(maxHP -B.getItemDamage(), R.getHP());
    }

    @Test
    void punch() {
        int maxHP = R.getHP();
        B.punch(R);
        Assertions.assertEquals(R.getHP(), maxHP - B.getBaseDamage());

    }
}