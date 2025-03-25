package game.entity.enemy;

import resources.Images;

public class Horse extends Enemy{
    public Horse(int maxHealth)
    {
        super(maxHealth);
        image = Images.ENEMY2;
    }

    protected void addMoves()
    {

    }
}
