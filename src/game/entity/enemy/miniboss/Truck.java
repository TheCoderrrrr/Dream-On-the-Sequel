package game.entity.enemy.miniboss;

import game.entity.enemy.Enemy;
import resources.Images;

public class Truck extends Enemy {
    public Truck(int maxHealth)
    {
        super(maxHealth *= 2);
        image = Images.TRUCKENEMY;
    }

    protected void addMoves()
    {

    }
}
