package game.entity.enemy;

import resources.Images;

public class Soldier extends Enemy{
    public Soldier(int maxHealth)
    {
        super(maxHealth);
        image = Images.ENEMY1;
    }

    protected void addMoves()
    {

    }

}
