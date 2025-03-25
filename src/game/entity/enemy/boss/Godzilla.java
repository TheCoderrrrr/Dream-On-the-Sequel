package game.entity.enemy.boss;

import game.entity.enemy.Enemy;
import resources.Images;

public class Godzilla extends Enemy {
    public Godzilla(int maxHealth)
    {
        super(maxHealth);
        health = maxHealth;
        image = Images.GODZILLA;

    }

    protected void addMoves()
    {

    }
}
