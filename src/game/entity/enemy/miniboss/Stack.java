package game.entity.enemy.miniboss;

import game.entity.enemy.Enemy;
import resources.Images;

public class Stack extends Enemy {
    public Stack(int maxHealth)
    {
        super(maxHealth *= 2);
        image = Images.STACKENEMY;
    }

    protected void addMoves()
    {

    }
}
